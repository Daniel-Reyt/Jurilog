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

  postAvocat(nom: String, prenom: String, adresse: String, phone: String, username: String, password: String) {
    this.http.post(url + 'avocat', {
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
    this.http.post(url + 'client', {
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

  postRdv(date: String, heure: String, id_client: String, id_avocat: String,) {
    return this.http.post<any>(url + 'rdv', {
      date: date,
      heure_rdv: heure,
      status: 0,
      client: {
        'id': id_client
      },
      avocat: {
        'id': id_avocat
      }
    })
  }

  validerRdv(rdv: any) {
    rdv.status = 1
    return this.http.post<any>(url + 'rdv', rdv)
  }

  refuserRdv(rdv: any) {
    rdv.status = 2
    return this.http.post<any>(url + 'rdv', rdv)
  }

  postFacture(nb_heure: any, taux_honoraire: any, id_rdv: any, id_client: any, id_avocat: any) {
    return this.http.post<any>(url + 'facture', {
      nb_heure: nb_heure,
      taux_honoraire: taux_honoraire,
      status_facture: 0,
      rdv: {
        id: id_rdv,
        client: {
           id: id_client
          },
        avocat: {
          id: id_avocat
        }
      }
    })
  }
}
