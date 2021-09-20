import { Component, HostListener, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

@Injectable()
export class NavbarComponent implements OnInit {

  width: any;

  collapseNavBarSmall: boolean = true;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.width = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: Event) {
    this.width = window.innerWidth;
  }

  setCollapseNavBarSmall() {
    if (this.collapseNavBarSmall == true) {
      this.collapseNavBarSmall = false
      console.log(this.collapseNavBarSmall)
    } else {
      this.collapseNavBarSmall = true
      console.log(this.collapseNavBarSmall)
    }
  }

  Logout() {
    localStorage.clear()
    this.router.navigate([''])
  }
}
