import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {PostService} from "../../service/post.service";

@Component({
  selector: 'app-register-avocat',
  templateUrl: './register-avocat.component.html',
  styleUrls: ['./register-avocat.component.css']
})
export class RegisterAvocatComponent implements OnInit {

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
    this.postService.postAvocat(
      this.RegisterForm.controls.nom.value,
      this.RegisterForm.controls.prenom.value,
      this.RegisterForm.controls.adresse.value,
      this.RegisterForm.controls.phone.value,
      this.RegisterForm.controls.username.value,
      this.RegisterForm.controls.password.value)
  }
}
