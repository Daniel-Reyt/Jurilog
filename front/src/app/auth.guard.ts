import { Injectable } from '@angular/core';
import { CanActivate, Router} from '@angular/router';
import {AuthService} from "./service/auth.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService,
              private router: Router) {
  }

  canActivate():boolean {
    if (!this.authService.getToken()) {
      this.router.navigateByUrl("");
    }
    return this.authService.getToken();
  }
}