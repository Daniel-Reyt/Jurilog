import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm, NgModel} from "@angular/forms";
import {GetService} from "../service/get.service";
import {PostService} from "../service/post.service";
import localeFr from "@angular/common/locales/fr";
import { registerLocaleData } from "@angular/common";
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.css']
})
export class FactureComponent implements OnInit {
  id_rdv: any;

  isCreate: boolean = true;

  facture: any;
  dateRdv = new Date();

  facture_id: any;
  status_facture: any;

  taux: any;
  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private getService: GetService,
              private postService: PostService) { }

  ngOnInit(): void {
    this.id_rdv = this.activatedRoute.snapshot.paramMap.get('id_rdv');
    
    this.checkIfRdvHadFacture();

    registerLocaleData(localeFr, "fr");
  }

  checkIfRdvHadFacture() {
    if (this.id_rdv == null) {
      this.router.navigate(['/rdv'])
    } else {
      this.getService.getFactureByRdv(this.id_rdv).toPromise().then((res: any) => {
        console.log(res)
        this.facture_id = res.id
        this.status_facture = res.statusFacture
          if (this.status_facture == "-1") {
            this.isCreate = true
          } else if (this.status_facture != "-1") {
            this.isCreate = false;
            this.facture = res
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
}
