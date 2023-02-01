import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';



@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  logged = false;

	constructor(private as:AuthService, private r : Router) { }

	ngOnInit(): void {
    this.as.authObs.subscribe((res)=>{
      if(res) {
        this.logged = true
      } else {
        this.logged = false
      }
    })
	}

	submit(f:NgForm) {
    this.as.login(f.value).subscribe((res)=>{
      this.r.navigate(["/"])
		})
	}
  logout(){
      this.as.logout()
  }

}

