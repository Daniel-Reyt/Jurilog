import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { url } from "../../main"

@Component({
  selector: 'app-four-oh-four',
  templateUrl: './four-oh-four.component.html',
  styleUrls: ['./four-oh-four.component.css']
})
export class FourOhFourComponent implements OnInit {

  constructor(private http: HttpClient,
              private router: Router) { }

  ngOnInit(): void {
  }

  remainDatas() {
    this.router.navigate([''])
  }
}
