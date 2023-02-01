import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.scss']
})
export class HeroComponent implements OnInit {

  logged = false;

	constructor(private as:AuthService) { }

	ngOnInit(): void {
    this.as.authObs.subscribe((res)=>{
      if(res) {
        this.logged = true
      } else {
        this.logged = false
      }
    })
	}
}
