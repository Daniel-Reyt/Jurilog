import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {GetService} from "../../service/get.service";
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-login-avocat',
  templateUrl: './login-avocat.component.html',
  styleUrls: ['./login-avocat.component.css'],
})

export class LoginAvocatComponent implements OnInit {

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

  login() {
    this.getService.getAllAvocats().subscribe((value: any) => {
      for (let i = 0; i < value.length; i++) {
        if (this.LoginForm.controls.username.value === value[i].username && this.LoginForm.controls.password.value === value[i].password) {
          localStorage.setItem("isLogin", String(true))
          localStorage.setItem("id_avocat", value[i].id);
          localStorage.setItem("id_client", "");
          localStorage.setItem("type", value[i].type);
          this.getService.getBalanceByAvocat(value[i].id).toPromise().then((res: any) => {
            if (res != null) {
              this.router.navigate(['/home']).then(r => {})
            } else if  (res === null) {
              this.postService.createNewBalanceAvocat(value[i].id, value[i].id, 0).toPromise().then((resNewBal) => {
                this.router.navigate(['/home']).then(r => {})
              })
            }
          })
        }
      }
    })
  }


}
