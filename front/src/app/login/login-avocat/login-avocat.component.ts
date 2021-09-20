import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-avocat',
  templateUrl: './login-avocat.component.html',
  styleUrls: ['./login-avocat.component.css']
})
export class LoginAvocatComponent implements OnInit {

  LoginForm!: FormGroup;

  constructor(private fb: FormBuilder,
              private http: HttpClient,
              private router: Router) { }

  ngOnInit(): void {
    this.LoginForm = this.fb.group({
      username: '',
      password: ''
    })
  }

  login() {
    this.http.get('http://localhost:8888/avocats').toPromise().then((res: any) => {
      for (let i = 0; i < res.length; i++) {
        if (this.LoginForm.controls.username.value === res[i].username) {
          if (this.LoginForm.controls.password.value === res[i].password) {
            localStorage.setItem("id_avocat", res[i].id);
            localStorage.setItem("id_client", "");
            localStorage.setItem("type", res[i].type);
            this.router.navigate(['/home'])
          }
        }
      }
    })
  }
}
