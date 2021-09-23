import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {PostService} from "../../service/post.service";

@Component({
  selector: 'app-register-client',
  templateUrl: './register-client.component.html',
  styleUrls: ['./register-client.component.css']
})
export class RegisterClientComponent implements OnInit {

  RegisterForm!: FormGroup;

  constructor(private fb: FormBuilder,
              private postService: PostService) { }

  ngOnInit(): void {
    this.RegisterForm = this.fb.group({
      nom: '',
      prenom: '',
      adresse: '',
      phone: '',
      username: '',
      password: ''
    })


  }

  register() {
    this.postService.postClient(
      this.RegisterForm.controls.nom.value,
      this.RegisterForm.controls.prenom.value,
      this.RegisterForm.controls.adresse.value,
      this.RegisterForm.controls.phone.value,
      this.RegisterForm.controls.username.value,
      this.RegisterForm.controls.password.value)
  }
}
