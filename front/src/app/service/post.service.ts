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

  postDatas() {
    this.http.post(url + 'client', {
      nom: 'reyt',
      prenom: 'daniel',
      adresse: '11 rue de la gare',
      phone: '0609336279',
      username: 'dada',
      password: 'dada',
    })

    this.http.post(url + 'avocat', {
      nom: 'hofman',
      prenom: 'louise',
      adresse: '24 rue de la houblonnière',
      phone: '0101010101',
      username: 'louise',
      password: 'hofman',
    })

    this.http.post<any>(url + 'rdv', {
      date: '10-01-2001',
      heure_rdv: '10:30',
      status: 0,
      client: {
        id: 1
      },
      avocat: {
        id: 1
      }
    })

    this.http.post<any>(url + 'facture', {
      nb_heure: 10,
      taux_honoraire: 150,
      status_facture: 0,
      rdv: {
        id: 1,
        client: {
          id: 1
        },
        avocat: {
          id: 1
        }
      }
    })
  }

}
