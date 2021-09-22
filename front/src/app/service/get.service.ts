import { url } from "../../main"
import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GetService {
  avocats: any;

  constructor(private http: HttpClient) { }

  // gets of avocats / clients
  getAllAvocats():any {
    return this.http.get<any>( url + 'avocats')
  }

  getAllClients():any {
    return this.http.get<any>( url + 'clients')
  }

  // gets of rdvs
  getAllRdvs():any {
    return this.http.get<any>( url + 'rdvs')
  }

  getRdvByDate(date: String):any {
    return this.http.get<any>( url + 'rdvByDate/' + date)
  }

  getRdvById(id: String):any {
    return this.http.get<any>( url + 'rdv/' + id)
  }

  // gets of factures
  getAllFactures():any {
    return this.http.get<any>( url + 'factures')
  }
  getFactureByRdv(id_rdv: String):any {
    return this.http.get<any>( url + 'factureByRdv/' + id_rdv)
  }
}
