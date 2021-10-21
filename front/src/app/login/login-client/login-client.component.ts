import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {GetService} from "../../service/get.service";
import { PostService } from 'src/app/service/post.service';

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
              private getService: GetService,
              private postService: PostService) { }

  ngOnInit(): void {
    this.LoginForm = this.fb.group({
      username: '',
      password: ''
    })
  }

  balance: any;

  login() {
    this.getService.getAllClients().subscribe((value: any) => {
      for (let i = 0; i < value.length; i++) {
        if (this.LoginForm.controls.username.value === value[i].username && this.LoginForm.controls.password.value === value[i].password) {
          localStorage.setItem("id_avocat", "");
          localStorage.setItem("id_client", value[i].id);
          localStorage.setItem("type", value[i].type);
          localStorage.setItem("isLogin", String(true));
          this.getService.getBalanceByClient(value[i].id).toPromise().then((res: any) => {
            if (res != null) {
              this.router.navigate(['/home']).then(r => {})
            } else if  (res === null) {
              this.postService.createNewBalance(value[i].id, value[i].id, 0).toPromise().then((resNewBal) => {
                this.router.navigate(['/home']).then(r => {})
              })
            }
          })
        }
      }
    })
  }
}
