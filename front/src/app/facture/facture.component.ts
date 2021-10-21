import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm, NgModel} from "@angular/forms";
import {GetService} from "../service/get.service";
import {PostService} from "../service/post.service";
import localeFr from "@angular/common/locales/fr";
import { registerLocaleData } from "@angular/common";
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.css']
})
export class FactureComponent implements OnInit {
  id_rdv: any;
  id_client: any;

  isCreate: boolean = true;

  facture: any;
  dateRdv = new Date();

  facture_id: any;
  status_facture: any;

  taux: any;

  isPayer: any;
  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private getService: GetService,
              private postService: PostService) { }

  ngOnInit(): void {
    this.id_rdv = this.activatedRoute.snapshot.paramMap.get('id_rdv');
    this.id_client = localStorage.getItem('id_client');
    this.getBalance();

    this.checkIfRdvHadFacture();

    this.getBalance();
    registerLocaleData(localeFr, "fr");
  }

  checkIfRdvHadFacture() {
    if (this.id_rdv == null) {
      this.router.navigate(['/rdv'])
    } else {
      this.getService.getFactureByRdv(this.id_rdv).toPromise().then((res: any) => {
        this.facture_id = res.id
        this.status_facture = res.statusFacture
          if (this.status_facture == "-1") {
            this.isCreate = true
          } else if (this.status_facture != "-1") {
            this.isCreate = false;
            this.facture = res;
            this.dateRdv = this.facture.dateRdv
          }
      }).catch(() => {
        
      })
    }
  }

  submitFacture() {
    this.taux = document.getElementsByTagName("input")[0].value;
    this.getService.getRdvById(this.id_rdv).toPromise().then((res: any) => {
      this.postService.postFacture(this.taux, res, this.facture_id).toPromise().then((res: any) => {
        this.checkIfRdvHadFacture()
      })
    })

  }

  PrintFacture(facture: any) {
    let element = document.getElementById("facture");

    if (element === null) {

    } else {
      html2canvas(element).then(canvas => {
        const contentDataURL = canvas.toDataURL('image/png')  
        let pdf = new jspdf.jsPDF('l', 'px', 'a4'); //Generates PDF in landscape mode
        //let pdf = new jspdf.jsPDF('p', 'px', 'a4'); //Generates PDF in portrait mode
        pdf.addImage(contentDataURL, 'PNG', 0, 0, 630.0, 200.0);
        pdf.save(facture.rdv.client.nom + "-" + facture.rdv.client.prenom + "_" + facture.rdv.avocat.nom + "-" + facture.rdv.avocat.prenom + "_" + facture.rdv.date + ".pdf");   
      }); 
    }
  }

  //balance 
  balance: any;
  payerFacture(facture: any) {
    if (this.balance.montant > this.facture.totalFacture) {
      this.removeMontant(this.balance.montant, this.facture.totalFacture);
      this.setStatusToPayer(1);
    } else {
      Swal.fire({
        'title': "pas assez de fonds !",
        'icon': "warning"
      })
    }
  }
  setStatusToPayer(status: number) {
    this.getService.getRdvById(this.id_rdv).toPromise().then((res: any) => {
      this.postService.setStatusFacture(res, this.facture_id, status).toPromise().then((res: any) => {
        this.checkIfFactureIsPayer();
      })
    })
  }
  checkIfFactureIsPayer() {
    if (this.id_rdv == null) {
      this.router.navigate(['/rdv'])
    } else {
      this.getService.getFactureByRdv(this.id_rdv).toPromise().then((res: any) => {
        this.status_facture = res.statusFacture
          if (this.status_facture != "-1" || this.status_facture != "1") {
            Swal.fire({
              'text': "votre facture as étais payée",
              'icon': "success"
            }).then((res) => {
              this.router.navigate(['/rdv'])
            })
          }
      }).catch(() => {
        
      })
    }
  }

  isPositive(montant: number) {
    if (montant > 0) {
      return true
    } else {
      return false;
    }
  }
  
  getBalance() {
    this.getService.getBalanceByClient(this.id_client).toPromise().then((res: any) => {
      this.balance = res
    })
  }

  removeMontant(oldMontant:number, montantToRemove: number) {
    const new_montant = oldMontant - montantToRemove
    this.postService.postNewBalance(this.id_client, this.balance.id, new_montant).toPromise().then((res: any) => {
      this.getBalance();
    })
  }

  addMontant(oldMontant:number, montantToAdd: number) {
    const new_montant = oldMontant + montantToAdd
    this.postService.postNewBalance(this.id_client, this.balance.id, new_montant).toPromise().then((res: any) => {
      this.getBalance()
    })
  }
}
