import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-client',
  templateUrl: './login-client.component.html',
  styleUrls: ['./login-client.component.css']
})
export class LoginClientComponent implements OnInit {

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
    this.http.get('http://localhost:8888/clients').toPromise().then((res: any) => {
      console.log(res)
      for (let i = 0; i < res.length; i++) {
        if (this.LoginForm.controls.username.value === res[i].username) {
          if (this.LoginForm.controls.password.value === res[i].password) {
            localStorage.setItem("id_avocat", "");
            localStorage.setItem("id_client", res[i].id);
            localStorage.setItem("type", res[i].type);
            this.router.navigate(['/home'])
          }
        }
      }
    })
  }
}
