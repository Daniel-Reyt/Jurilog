import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {GetService} from "../../service/get.service";

@Component({
  selector: 'app-login-client',
  templateUrl: './login-client.component.html',
  styleUrls: ['./login-client.component.css']
})
export class LoginClientComponent implements OnInit {

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
    this.getService.getAllClients().subscribe((value: any) => {
      for (let i = 0; i < value.length; i++) {
        if (this.LoginForm.controls.username.value === value[i].username) {
          if (this.LoginForm.controls.password.value === value[i].password) {
            localStorage.setItem("id_avocat", "");
            localStorage.setItem("id_client", value[i].id);
            localStorage.setItem("type", value[i].type);
            localStorage.setItem("isLogin", String(true))
            this.router.navigate(['/home'])
          }
        }
      }
    })
  }
}
