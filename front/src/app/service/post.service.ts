import { Injectable } from '@angular/core';
import Swal from "sweetalert2";
import {HttpClient} from "@angular/common/http";
import {url} from "../../main";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient,
              private router: Router) { }

  createNewBalance(id_client: any, id_balance: any, new_montant: number) {
    return this.http.post(`${url}newBalance`, {
      id: id_balance,
      client: {
        id: id_client
      },
      montant: new_montant
    })
  }

  postNewBalance(id_client: any, id_balance:number, new_montant: number):any {
    return this.http.post(`${url}postNewMontant`, {
      id: id_balance,
      client: {
        id: id_client
      },
      montant: new_montant
    })
  }

  postAvocat(nom: String, prenom: String, adresse: String, phone: String, username: String, password: String) {
    this.http.post(`${url}avocat`, {
      nom: nom,
      prenom: prenom,
      adress: adresse,
      phone: phone,
      username: username,
      password: password,
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

  postClient(nom: String, prenom: String, adresse: String, phone: String, username: String, password: String) {
    this.http.post(`${url}client`, {
      nom: nom,
      prenom: prenom,
      adresse: adresse,
      phone: phone,
      username: username,
      password: password,
    }).subscribe((res: any) => {
      if (res == "201") {
        Swal.fire({
          'title': "votre compte as étais créer",
          'icon': "success"
        }).then(() => {
          this.router.navigate(['/login-client'])
        })
      }
    })
  }

  postRdv(date: String, heure: String, id_client: String, id_avocat: String, rdv_type: string) {
    return this.http.post<any>(`${url}rdv`, {
      date: date,
      heure: heure,
      status: 0,
      client: {
        'id': id_client
      },
      avocat: {
        'id': id_avocat
      },
      type: {
        id: rdv_type
      }
    })
  }

  validerRdv(rdv: any) {
    return this.http.post<any>(`${url}rdvValider`, rdv)
  }

  refuserRdv(rdv: any) {
    return this.http.post<any>(`${url}rdvRefuser`, rdv)
  }

  postFacture(taux_honoraire: any, rdv: any, id_facture: any) {
    return this.http.put<any>(`${url}facture`, {
      id: id_facture,
      nbHeure: 1,
      tauxHonoraire: taux_honoraire,
      rdv: rdv
    })
  }
  setStatusFacture(rdv: any, id_facture: any, status: number) {
      return this.http.put<any>(`${url}setFactureToPayer`, {
        id: id_facture,
        rdv: rdv,
      })
    }
}
