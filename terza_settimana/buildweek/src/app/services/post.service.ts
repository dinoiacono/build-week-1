import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ModificaPost, NuovoPost, Post } from '../interfaces/post.interface';
import { map, tap } from 'rxjs/operators';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  urlPosts:string = environment.url

  getPost(){
    return this.http.get<Post[]>(`${this.urlPosts}`)
  }

  getPostbyID(postID:number){
    return this.http.get<Post>(`${this.urlPosts}/${postID}`)
  }

  nuovoPost(articolo:NuovoPost){
    return this.http.post(`${this.urlPosts}`, articolo)
  }

  modificaPost(articolo:ModificaPost){
    return this.http.put(`${this.urlPosts}/${articolo.id}`, articolo)
  }

  eliminaPost(postID:number){
    return this.http.delete(`${this.urlPosts}/${postID}`)
  }

  nuovoCommento(f:NgForm, articolo:Post){
    articolo.comments?.push(f.value)
    return this.http.put(`${this.urlPosts}/${articolo.id}`, articolo)
  }

}
