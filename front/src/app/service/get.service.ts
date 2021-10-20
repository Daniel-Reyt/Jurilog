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
    return this.http.get<any>( `${url}avocats`)
  }

  getAllClients():any {
    return this.http.get<any>( `${url}clients`)
  }

  // gets of rdvs
  getAllRdvs():any {
    return this.http.get<any>( `${url}rdvs`)
  }

  getRdvByDate(date: String):any {
    return this.http.get<any>( `${url}rdvByDate/${date}`)
  }

  getRdvById(id: String):any {
    return this.http.get<any>( `${url}rdv/${id}`)
  }

  getRdvByDateAndByIdClient(filtreByDate: any, id_client: any) {
    return this.http.get<any>(`${url}rdvByDateRdvIdClient/${filtreByDate}/${id_client}`)
  }

  getRdvByDateAndByIdAvocat(filtreByDate: any, id_avocat: any) {
    return this.http.get<any>(`${url}rdvByDateRdvIdAvocat/${filtreByDate}/${id_avocat}`)
  }

  getRdvByIdAndByIdClient(id: String, id_client: String):any {
    return this.http.get<any>( `${url}rdvByIdRdvIdClient/${id}/${id_client}`)
  }

  getRdvByIdAndByIdAvocat(id: String, id_avocat: String):any {
    return this.http.get<any>( `${url}rdvByIdRdvIdAvocat/${id}/${id_avocat}`)
  }

  getRdvByIdClient(id: String) {
    return this.http.get<any>( `${url}rdvByIdClient/${id}`)
  }
  getRdvByIdAvocat(id: String) {
    return this.http.get<any>( `${url}rdvByIdAvocat/${id}`)
  }
  getRdvByIdAvocatAndDateAndHour(id: String, date: String, heure: String) {
    return this.http.get<any>( `${url}rdvByIdAvocatAndDateAndHour/${id}/${date}/${heure}`)
  }
  // gets of factures
  getFactureByRdv(id_rdv: String):any {
    return this.http.get<any>( `${url}factureByRdv/${id_rdv}`)
  }

  //get type of rdv
  getAllTypeOfRdv():any {
    return this.http.get<any>( `${url}typeRdvs`)
  }

  //get rdv by status rdv
  getAllRdvByStatusAndAvocat(status: number, id_avocat: number):any {
    return this.http.get<any>(`${url}rdvByStatusRdvAndAvocat/${status}/${id_avocat}`)
  }
  getAllRdvByStatusAndClient(status: number, id_client: number):any {
    return this.http.get<any>(`${url}rdvByStatusRdvAndAvocat/${status}/${id_client}`)
  }

    //get rdv by status factures = pas de factures
    getAllRdvByStatusFacturesAndAvocat(id_avocat: number):any {
      return this.http.get<any>(`${url}rdvByStatusFactureRdvAndAvocat/${id_avocat}`)
    }
    getAllRdvByStatusFacturesAndClient(id_client: number):any {
      return this.http.get<any>(`${url}rdvByStatusFactureRdvAndClient/${id_client}`)
    }

    getBalanceByClient(id_client: number): any {
      return this.http.get<any>(`${url}getBalanceOfClient/${id_client}`)
    }
}
