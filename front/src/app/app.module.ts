import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginClientComponent } from './login/login-client/login-client.component';
import { LoginAvocatComponent } from './login/login-avocat/login-avocat.component';
import { RdvComponent } from './rdv/rdv.component';
import { ChooseLoginComponent } from './login/choose-login/choose-login.component';
import { FactureComponent } from './facture/facture.component';
import { RegisterAvocatComponent } from './register/register-avocat/register-avocat.component';
import { RegisterClientComponent } from './register/register-client/register-client.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatNativeDateModule} from '@angular/material/core';
import {AuthService} from "./service/auth.service";
import {AuthGuard} from "./auth.guard";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    LoginClientComponent,
    LoginAvocatComponent,
    RdvComponent,
    ChooseLoginComponent,
    FactureComponent,
    RegisterAvocatComponent,
    RegisterClientComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
