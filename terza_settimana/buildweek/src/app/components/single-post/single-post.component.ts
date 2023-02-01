import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Commento, Post } from 'src/app/interfaces/post.interface';
import { PostService } from 'src/app/services/post.service';

@Component({
	selector: 'app-single-post',
	templateUrl: './single-post.component.html',
	styleUrls: ['./single-post.component.scss']
})
export class SinglePostComponent implements OnInit {

	constructor(private router:Router ,private route: ActivatedRoute,private ps:PostService) {}

	post!: Post
  postTotal : Post[] = []
  idPrimoPost!: number
  idUltimoPost!: number
  notFound: boolean = false


	ngOnInit() {
    this.avvio()
    this.ps.getPost().subscribe((res)=> {
      this.postTotal = res
      this.idPrimoPost = Number(res[0].id)
      this.idUltimoPost = Number(res.slice(-1)[0].id)
    })
	}

  avvio(){
		this.route.queryParams.subscribe(params => {
      if (params['id']) {
        // this.post = this.postTotal.filter(p => p.id)
        this.ps.getPostbyID(params['id']).subscribe((res) => {
          this.post = res
          this.notFound = false
        }, (err) => {
          this.notFound = true
        })
      } else {
        this.ps.getPostbyID(1).subscribe((res) => {
          this.post = res
        })
      }
			}
		);
  }

  cambiaPagina(controller: boolean){

    controller ? this.post.id++ : this.post.id--
    this.router.navigate(['/post'], { queryParams: { id: this.post.id } });
  }



  aggiungiCommento(form:NgForm){
    this.ps.nuovoCommento(form,this.post).subscribe((res) => {
      this.avvio()
    })
  }

}

