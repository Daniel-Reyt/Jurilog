import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import Swal from "sweetalert2";

@Component({
  selector: 'app-register-client',
  templateUrl: './register-client.component.html',
  styleUrls: ['./register-client.component.css']
})
export class RegisterClientComponent implements OnInit {

  RegisterForm!: FormGroup;

  constructor(private fb: FormBuilder,
              private http: HttpClient,
              private router: Router) { }

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
    this.http.post('http://localhost:8888/client', {
      nom: this.RegisterForm.controls.nom.value,
      prenom: this.RegisterForm.controls.prenom.value,
      adress: this.RegisterForm.controls.adresse.value,
      phone: this.RegisterForm.controls.phone.value,
      username: this.RegisterForm.controls.username.value,
      password: this.RegisterForm.controls.password.value,
    }).subscribe((res: any) => {
      if (res == "201") {
        Swal.fire({
          'title': "votre compte as étais créer",
          'icon': "success"
        }).then(() => {
          this.router.navigate(['/login-avocat'])
        })
      }
    })
  }
}
