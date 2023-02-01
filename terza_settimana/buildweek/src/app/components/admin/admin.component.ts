import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ModificaPost, NuovoPost, Post } from 'src/app/interfaces/post.interface';
import { PostService } from 'src/app/services/post.service';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor(private ps:PostService) { }

  posts: Post[] = []
  postEdit!: Post
  postDelete!: number
  editMode: boolean = false

  ngOnInit(): void {
    this.getPosts()
  }

  getPosts(){
    this.ps.getPost().subscribe((res:any) => {
      this.posts = res
    })
  }

  elimina(postID:number){
    this.postDelete = postID
  }

  modifica(postID:number){
    this.editMode = true
    this.posts.forEach(element => {
      if (postID == element.id) this.postEdit = element
    });
  }

  inviaElimina(postID:number){
    this.ps.eliminaPost(postID).subscribe((res) => {
      this.posts = this.posts.filter(p=>p.id!=postID)
    })
  }
  inviaModifica(form:NgForm,postID:number){
    let articolo: ModificaPost = { id: postID, title: form.value.title, body: form.value.body }
    this.ps.modificaPost(articolo).subscribe((res) => {
      this.posts = []
      this.editMode = false
      this.getPosts()
    })
  }

  annullaModifica(){
    this.editMode = false
  }

  nuovoArticolo(form:NgForm){
    let articolo : NuovoPost = { userId: 1, title: form.value.title, body: form.value.body, imgUrl: form.value.url }
    this.ps.nuovoPost(articolo).subscribe((res) => {
      this.posts = []
      this.getPosts()
    })
  }



}
