import {Component, HostListener, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DatePipe} from "@angular/common";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {GetService} from "../service/get.service";
import {PostService} from "../service/post.service";

@Component({
  selector: 'app-rdv',
  templateUrl: './rdv.component.html',
  styleUrls: ['./rdv.component.css']
})
export class RdvComponent implements OnInit {
  selectedOption: any = "Id";

  filtreByDate: any;
  filtreByIdRdv: any;

  rdvs: any;
  rdv: any;

  purposeRdvForm!: FormGroup;
  avocat: any;
  avocats: any;

  id_client: any;
  id_avocat: any;

  constructor(private fb: FormBuilder,
              private router: Router,
              private getService: GetService,
              private postService: PostService) { }

  ngOnInit(): void {
    this.getService.getAllAvocats().toPromise().then((res: any) => {
      this.avocats = res
    });

    this.purposeRdvForm = this.fb.group({
      dateRdv: '',
      heureRdv: '',
      avocatRdv: ''
    })

    this.id_client = localStorage.getItem('id_client');
    console.log("client " + this.id_client)
    this.id_avocat = localStorage.getItem('id_avocat');
    console.log("avocat " + this.id_avocat)

    if (this.id_client != "") {
      this.getRdvByIdClient()
    } else {
      this.getRdvByIdAvocat();
    }
  }

  getRdvByDate() {
    if (this.filtreByDate != null) {
      if (this.id_client != "") {
      this.getService.getRdvByDateAndByIdClient(this.filtreByDate, this.id_client).toPromise().then((res: any) => {
        if (res == null) {
          this.getRdvByIdClient();
        } else {
          if (res.status == 0) {
            res.status = "en attente"
          }
          if (res.status == 1) {
            res.status = "approuvé"
          }
          if (res.status == 2) {
            res.status = "refusé"
          }
          this.rdvs = [];
          this.rdvs = res;
        }
      })
    } else {
      this.getService.getRdvByDateAndByIdAvocat(this.filtreByDate, this.id_avocat).toPromise().then((res: any) => {
        console.log(res)
        if (res.length == 0) {
          this.getRdvByIdAvocat();
        } else {
          if (res.status == 0) {
            res.status = "en attente"
          }
          if (res.status == 1) {
            res.status = "approuvé"
          }
          if (res.status == 2) {
            res.status = "refusé"
          }
          this.rdvs = [];
          this.rdvs = res
        }
      })
    }
    }
  }

  getRdvById() {
    if (this.filtreByIdRdv != null) {
      if (this.id_client != "") {
        this.getService.getRdvByIdAndByIdClient(this.filtreByIdRdv, this.id_client).toPromise().then((res: any) => {
          console.log(res)
          if (res.length == 0) {
            this.getRdvByIdClient();
          } else {
            if (res.status == 0) {
              res.status = "en attente"
            }
            if (res.status == 1) {
              res.status = "approuvé"
            }
            if (res.status == 2) {
              res.status = "refusé"
            }
            this.rdvs = [];
            this.rdvs = res
          }
        })
      } else {
        this.getService.getRdvByIdAndByIdAvocat(this.filtreByIdRdv, this.id_avocat).toPromise().then((res: any) => {
          if (res.length == 0) {
            this.getRdvByIdAvocat();
          } else {
            if (res.status == 0) {
              res.status = "en attente"
            }
            if (res.status == 1) {
              res.status = "approuvé"
            }
            if (res.status == 2) {
              res.status = "refusé"
            }
            this.rdvs = [];
            this.rdvs = res
          }
        })
      }
    }
  }

  getRdvByIdClient() {
      this.getService.getRdvByIdClient(this.id_client).toPromise().then((res: any) => {
        if (res == null) {
          this.rdvs = [];
        } else {
          if (res.status == 0) {
            res.status = "en attente"
          }
          if (res.status == 1) {
            res.status = "approuvé"
          }
          if (res.status == 2) {
            res.status = "refusé"
          }
          this.rdvs = [];
          this.rdvs = res
        }
      })
  }

  getRdvByIdAvocat() {
    this.getService.getRdvByIdAvocat(this.id_avocat).toPromise().then((res: any) => {
      if (res == null) {
        this.rdvs = [];
      } else {
        console.log(res)
        if (res.status == 0) {
          res.status = "en attente"
        }
        if (res.status == 1) {
          res.status = "approuvé"
        }
        if (res.status == 2) {
          res.status = "refusé"
        }
        this.rdvs = [];
        this.rdvs = res
      }
    })
  }
  submitRdv() {
    this.postService.postRdv(
      this.purposeRdvForm.controls.dateRdv.value,
      this.purposeRdvForm.controls.heureRdv.value,
      this.id_client,
      this.purposeRdvForm.controls.avocatRdv.value).toPromise().then((res) => {
        if (this.id_client != "") {
          this.getRdvByIdClient()
        } else {
          this.getRdvByIdAvocat()
        }
    })
  }

  validerRdv(rdv: any) {
    this.postService.validerRdv(rdv).toPromise().then((res) => {
      if (this.id_client != "") {
        this.getRdvByIdClient()
      } else {
        this.getRdvByIdAvocat()
      }
    })
  }
  refuserRdv(rdv: any) {
    this.postService.refuserRdv(rdv).toPromise().then((res) => {
      if (this.id_client != "") {
        this.getRdvByIdClient()
      } else {
        this.getRdvByIdAvocat()
      }
    })
  }

  redirectFacture(rdv: any) {
      this.router.navigate(['/facture/' + rdv.id])
  }

  resetFilters() {
    if (this.id_client != "") {
      this.getRdvByIdClient()
    } else {
      this.getRdvByIdAvocat()
    }
  }
}
