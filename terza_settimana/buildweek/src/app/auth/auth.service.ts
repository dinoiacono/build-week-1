import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, catchError, map, tap, throwError } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

export interface SignupData {
	name:string,
	email:string,
	password:string
}

export interface AuthResponse {
	accessToken: string,
	user: {
		email: string,
		id: number,
		nome: string
	}
}

export interface LoginData {
	email:string,
	password:string
}

@Injectable({
	providedIn: 'root'
})
export class AuthService {

	authSubj = new BehaviorSubject<null|AuthResponse>(null)
	authObs = this.authSubj.asObservable()
    isLoggedIn$ = this.authObs.pipe(map(user => !!user));
	loggedObs = this.authObs.pipe(map((res)=>{
		if(res) {return true}
		return false
	}))

    jwtHelper = new JwtHelperService()

	  url = "http://localhost:4201/"
    autoLogoutTimer: any;

	constructor(private http:HttpClient, private router:Router) {
        this.restoreUser()
     }

	signup(data:SignupData){
		return this.http.post<AuthResponse>(this.url + "register", data).pipe(catchError(this.errors))
	}

	login(data:LoginData) {
		return this.http.post<AuthResponse>(this.url + "login", data).pipe(tap((res)=>{
			localStorage.setItem("auth", JSON.stringify(res))
			this.authSubj.next(res)
		}), catchError(this.errors))
	}

	logout() {
		localStorage.removeItem("auth")
		this.authSubj.next(null)
        this.router.navigate(["/"])
	}

    restoreUser() {
        const userJson = localStorage.getItem('auth');
        if (!userJson) {
            return;
        }
        const user: AuthResponse = JSON.parse(userJson);
        if (this.jwtHelper.isTokenExpired(user.accessToken)) {
            return;
        }
        this.authSubj.next(user);

        const expirationDate = this.jwtHelper.getTokenExpirationDate(user.accessToken) as Date;
        this.autoLogout(expirationDate);
    }

    autoLogout(expirationDate: Date) {
        const expMs = expirationDate.getTime() - new Date().getTime(); //ms rimasti primache scada
        this.autoLogoutTimer = setTimeout(() => {
            this.logout();
        }, expMs);
    }

    private errors(err: any) {
        switch (err.error) {
            case "Email and password are required":
                throw new Error('Email e password sono obbligatorie');
                break;
            case "Email already exists":
                return throwError('Utente già registrato');
                break;
            case "Email format is invalid":
                return throwError('Email scritta male');
                break;
            case "Cannot find user":
                return throwError("L'utente non esiste");
                break;
            default:
                return throwError('Errore nella chiamata');
                break
        }
    }
}
