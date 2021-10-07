import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {GetService} from "../service/get.service";
import {PostService} from "../service/post.service";
import localeFr from "@angular/common/locales/fr";
import { registerLocaleData } from "@angular/common";

@Component({
  selector: 'app-rdv',
  templateUrl: './rdv.component.html',
  styleUrls: ['./rdv.component.css']
})
export class RdvComponent implements OnInit {
  selectedOption: any = "Date";

  filtreByDate: any;
  filtreByIdRdv: any;

  rdvs: any;
  rdv: any;

  purposeRdvForm!: FormGroup;
  avocat: any;
  avocats: any;

  id_client: any;
  id_avocat: any;
  listeheures: number[]= [8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18];
  error_heure: any;

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
    registerLocaleData(localeFr, "fr");

    this.id_client = localStorage.getItem('id_client');
    this.id_avocat = localStorage.getItem('id_avocat');

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
          this.rdvs = [];
          this.rdvs = res;
        }
      })
    } else {
      this.getService.getRdvByDateAndByIdAvocat(this.filtreByDate, this.id_avocat).toPromise().then((res: any) => {
        if (res.length == 0) {
          this.getRdvByIdAvocat();
        } else {
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
          if (res.length == 0) {
            this.getRdvByIdClient();
          } else {
            this.rdvs = [];
            this.rdvs = res
          }
        })
      } else {
        this.getService.getRdvByIdAndByIdAvocat(this.filtreByIdRdv, this.id_avocat).toPromise().then((res: any) => {
          if (res.length == 0) {
            this.getRdvByIdAvocat();
          } else {
            this.rdvs = [];
            this.rdvs = res
          }
        })
      }
    }
  }

  getRdvByIdClient() {
      this.getService.getRdvByIdClient(this.id_client).toPromise().then((res: any) => {
        console.log(res)
        if (res == null) {
          this.rdvs = [];
        } else {
          this.rdvs = [];
          this.rdvs = res
        }
      })
  }

  getRdvByIdAvocat() {
    this.getService.getRdvByIdAvocat(this.id_avocat).toPromise().then((res: any) => {
      console.log(res)
      if (res == null) {
        this.rdvs = [];
      } else {
        this.rdvs = [];
        this.rdvs = res
      }
    })
  }
  submitRdv() {
    console.log(this.purposeRdvForm.controls.avocatRdv.value);
    console.log(this.purposeRdvForm.controls.dateRdv.value);
    console.log(this.purposeRdvForm.controls.heureRdv.value);

    this.getService.getRdvByIdAvocatAndDateAndHour(
      this.purposeRdvForm.controls.avocatRdv.value,
      this.purposeRdvForm.controls.dateRdv.value,
      this.purposeRdvForm.controls.heureRdv.value).toPromise().then((res: any) => {
        console.log(res)
        if (res.length === 0) {
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
          this.error_heure = ""
        }
        if (res.length > 0) {
          this.error_heure = "merci de choisir une autre horaire car votre avocat as déja un rendez-vous"
        }
      }).catch((err) => {
        console.log(err)
    });
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
