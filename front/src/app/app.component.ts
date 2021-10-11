import { HttpClient } from '@angular/common/http';
import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { url } from "../main"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{

  constructor(private http: HttpClient,
              private router: Router) {}

  ngOnInit() {
    this.decalerImage()
    setInterval(() => {
      this.decalerImage()
    }, 1000)
  }

  async decalerImage() {
    let pos_x = Math.round(Math.floor(Math.random() * 1080));
    let pos_y = Math.round(Math.floor(Math.random() * 1920));
    let img = document.getElementById('image');
    if (img === null) {
    } else  {
      img.style.paddingLeft = pos_x +"px";
      img.style.paddingTop= pos_y  +"px";
    }    
  }

  DROP() {
    this.http.get(url+'/deleteAll').toPromise().then((res) => {
      localStorage.clear()
      this.router.navigate(['/jfghkdfjhgkdj']).then(r => {})
    })
  }
}
