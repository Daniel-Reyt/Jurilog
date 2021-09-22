import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {GetService} from "../../service/get.service";

@Component({
  selector: 'app-login-avocat',
  templateUrl: './login-avocat.component.html',
  styleUrls: ['./login-avocat.component.css']
})
export class LoginAvocatComponent implements OnInit {

  LoginForm!: FormGroup;


  constructor(private fb: FormBuilder,
              private http: HttpClient,
              private router: Router,
              private getService: GetService) { }

  ngOnInit(): void {
    this.LoginForm = this.fb.group({
      username: '',
      password: ''
    })
  }

  login() {
    this.getService.getAllAvocats().subscribe((value: any) => {
      for (let i = 0; i < value.length; i++) {
        if (this.LoginForm.controls.username.value === value[i].username){
          if (this.LoginForm.controls.password.value === value[i].password) {
            localStorage.setItem("isLogin", String(true))
            localStorage.setItem("id_avocat", value[i].id);
            localStorage.setItem("id_client", "");
            localStorage.setItem("type", value[i].type);
            this.router.navigate(['/home']);
          }
        }
      }
    })
  }

}
