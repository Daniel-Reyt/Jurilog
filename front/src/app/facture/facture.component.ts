import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";
import {GetService} from "../service/get.service";
import {PostService} from "../service/post.service";

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

  nb_heure: any;
  taux_honoraire: any;

  nom_client: any;
  prenom_client: any;
  adresse_client: any;
  telephone_client: any;

  nom_avocat: any;
  prenom_avocat: any;
  adresse_avocat: any;
  telephone_avocat: any;
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
  }

  checkIfRdvHadFacture() {
    if (this.id_rdv == null) {
      this.router.navigate(['/rdv'])
    } else {
      this.getService.getFactureByRdv(this.id_rdv).toPromise().then((res: any) => {
          if (res == null) {
            this.isCreate = true
          } else {
            this.isCreate = false;
            this.nb_heure = res.nb_heure;
            this.taux_honoraire = res.taux_honoraire;

            this.nom_client = res.rdv.client.nom;
            this.prenom_client = res.rdv.client.prenom;
            this.adresse_client = res.rdv.client.adress;
            this.telephone_client = res.rdv.client.phone;

            this.nom_avocat = res.rdv.avocat.nom;
            this.prenom_avocat = res.rdv.avocat.prenom;
            this.adresse_avocat = res.rdv.avocat.adress;
            this.telephone_avocat = res.rdv.avocat.phone;
          }
      })
    }
  }

  addFacture() {
    this.getService.getRdvById(this.id_rdv).toPromise().then((res: any) => {
        this.id_avocat = res.avocat.id
        this.id_client = res.client.id
    })
    this.postService.postFacture(
      this.createFacture.controls.nb_heure.value,
      this.createFacture.controls.taux_honoraire.value,
      this.id_rdv, this.id_client, this.id_avocat).toPromise().then((res: any) => {
        this.checkIfRdvHadFacture()
        this.isCreate = false
    })
  }
}
