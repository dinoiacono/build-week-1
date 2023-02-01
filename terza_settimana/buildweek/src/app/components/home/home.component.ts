import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/interfaces/post.interface';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private ps:PostService) { }

  posts: Post[] = []

  ngOnInit(): void {
    this.getPosts()
  }

  getPosts(){
    this.ps.getPost().subscribe((res) => {
      this.posts = res
    })
  }

}
