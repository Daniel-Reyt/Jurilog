import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";
import {GetService} from "../service/get.service";
import {PostService} from "../service/post.service";
import localeFr from "@angular/common/locales/fr";
import { registerLocaleData } from "@angular/common";

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.css']
})
export class FactureComponent implements OnInit {

  createFacture!: FormGroup;

  id_rdv: any;
  id_client: any;
  id_avocat: any;

  isCreate: boolean = true;

  facture: any;
  dateRdv = new Date();

  facture_id: any;

  constructor(private router: Router,
              private activatedRoute: ActivatedRoute,
              private fb: FormBuilder,
              private getService: GetService,
              private postService: PostService) { }

  ngOnInit(): void {
    this.id_rdv = this.activatedRoute.snapshot.paramMap.get('id_rdv');
    this.checkIfRdvHadFacture();

    this.createFacture = this.fb.group({
      nb_heure: '',
      taux_honoraire: ''
    })
    registerLocaleData(localeFr, "fr");
  }

  checkIfRdvHadFacture() {
    console.log("check")
    if (this.id_rdv == null) {
      this.router.navigate(['/rdv'])
    } else {
      this.getService.getFactureByRdv(this.id_rdv).toPromise().then((res: any) => {
        console.log(res)
        this.facture_id = res.facture_id
          if (res.status_facture.equals("-1")) {
            this.isCreate = true
          } else {
            this.isCreate = false;
            this.facture = res
            this.dateRdv = this.facture.dateRdv
          }
      }).catch(() => {
      })
    }
  }

  editFacture() {
    this.getService.getRdvById(this.id_rdv).toPromise().then((res: any) => {
      this.id_client = res.client.id;
      this.id_avocat = res.avocat.id;
    })
    this.postService.postFacture(this.createFacture.controls.taux_honoraire.value, this.id_rdv, this.id_client, this.id_avocat, this.facture_id).toPromise().then((res: any) => {
      console.log(res)
      if (res.equals("201")) {
        this.checkIfRdvHadFacture()
      } else {

      }
    })
  }
}
