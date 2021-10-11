import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FactureComponent } from './facture/facture.component';
import {HomeComponent} from "./home/home.component";
import { ChooseLoginComponent } from './login/choose-login/choose-login.component';
import { LoginAvocatComponent } from './login/login-avocat/login-avocat.component';
import { LoginClientComponent } from './login/login-client/login-client.component';
import { RdvComponent } from './rdv/rdv.component';
import { RegisterAvocatComponent } from './register/register-avocat/register-avocat.component';
import { RegisterClientComponent } from './register/register-client/register-client.component';
import {AuthGuard} from "./auth.guard";
import { FourOhFourComponent } from './four-oh-four/four-oh-four.component';

const routes: Routes = [
  {path: '', component: ChooseLoginComponent},

  {path: 'login-avocat', component: LoginAvocatComponent},
  {path: 'login-client', component: LoginClientComponent},

  {path: 'register-avocat', component: RegisterAvocatComponent},
  {path: 'register-client', component: RegisterClientComponent},

  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},

  {path: 'facture', component: FactureComponent, canActivate: [AuthGuard]},
  {path: 'facture/:id_rdv', component: FactureComponent, canActivate: [AuthGuard]},

  {path: 'rdv', component: RdvComponent, canActivate: [AuthGuard]},

  {path: '**', component: FourOhFourComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
