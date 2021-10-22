import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { GetService } from "../service/get.service";
import { PostService } from "../service/post.service";
import localeFr from "@angular/common/locales/fr";
import { registerLocaleData } from "@angular/common";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-rdv',
  templateUrl: './rdv.component.html',
  styleUrls: ['./rdv.component.css']
})
export class RdvComponent implements OnInit {
  selectedOption: any = "statusRdv";

  filtreByDate: any;
  filtreByIdRdv: any;

  rdvs: any;
  rdv: any;

  purposeRdvForm!: FormGroup;
  avocat: any;
  avocats: any;
  rdvsType: any;

  id_client: any;
  id_avocat: any;
  listeheures: number[] = [8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18];
  error_heure: any;

  client_nom = "";
  avocat_nom = "";
  montant: any;

  constructor(private fb: FormBuilder,
    private router: Router,
    private getService: GetService,
    private postService: PostService) { }

  ngOnInit(): void {
    this.getService.getAllAvocats().toPromise().then((res: any) => {
      this.avocats = res
    });
    this.getService.getAllTypeOfRdv().toPromise().then((res: any) => {
      this.rdvsType = res
    });

    this.purposeRdvForm = this.fb.group({
      dateRdv: '',
      heureRdv: '',
      avocatRdv: '',
      rdvTypeSelected: ''
    })
    registerLocaleData(localeFr, "fr");

    this.id_client = localStorage.getItem('id_client');
    this.id_avocat = localStorage.getItem('id_avocat');

    if (this.id_client != "") {
      this.getRdvByIdClient();
      this.getBalance();
    } else if (this.id_avocat != "") {
      this.getRdvByIdAvocat();
      this.getBalance();
    }
  }

  getRdvByDate() {
    if (this.filtreByDate != null) {
      if (this.id_client != "") {
        this.getService.getRdvByDateAndByIdClient(this.filtreByDate, this.id_client).toPromise().then((res: any) => {
          if (res.length == 0) {
            Swal.fire({
              'text': "il n'y as pas de rendez-vous avec cet date pour cet id_client",
              'icon': "error"
            }).then((res) => {
              this.getRdvByIdClient();
              this.getBalance()
            })
          } else {
            this.rdvs = [];
            this.rdvs = res;
          }
        })
      } else {
        this.getService.getRdvByDateAndByIdAvocat(this.filtreByDate, this.id_avocat).toPromise().then((res: any) => {
          if (res.length == 0) {
            Swal.fire({
              'text': "il n'y as pas de rendez-vous avec cet date pour cet id_avocat",
              'icon': "error"
            }).then((res) => {
              this.getRdvByIdAvocat();
              this.getBalance()
            })
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
            Swal.fire({
              'text': "il n'y as pas de rendez-vous avec cet id_rdv pour cet id_client",
              'icon': "error"
            }).then((res) => {
              this.getRdvByIdClient();
              this.getBalance()
            })
          } else {
            this.rdvs = [];
            this.rdvs = res
          }
        })
      } else {
        this.getService.getRdvByIdAndByIdAvocat(this.filtreByIdRdv, this.id_avocat).toPromise().then((res: any) => {
          if (res.length == 0) {
            Swal.fire({
              'text': "il n'y as pas de rendez-vous avec cet id_rdv pour cet id_avocat",
              'icon': "error"
            }).then((res) => {
              this.getRdvByIdAvocat();
              this.getBalance()
            })
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
      if (res.length == 0) {
        Swal.fire({
          'text': "vous n'avez pas de rendez-vous",
          'icon': "error"
        }).then((res) => {
          this.rdvs = [];
        })
      } else {
        this.rdvs = [];
        this.rdvs = res
      }
    })
  }

  getRdvByIdAvocat() {
    this.getService.getRdvByIdAvocat(this.id_avocat).toPromise().then((res: any) => {
      if (res.length == 0) {
        Swal.fire({
          'text': "vous n'avez pas de rendez-vous",
          'icon': "error"
        }).then((res) => {
          this.rdvs = [];
        })
      } else {
        this.rdvs = [];
        this.rdvs = res
      }
    })
  }
  submitRdv() {

    this.getService.getRdvByIdAvocatAndDateAndHour(
      this.purposeRdvForm.controls.avocatRdv.value,
      this.purposeRdvForm.controls.dateRdv.value,
      this.purposeRdvForm.controls.heureRdv.value,
    ).toPromise().then((res: any) => {
      if (res.length === 0) {
        this.postService.postRdv(
          this.purposeRdvForm.controls.dateRdv.value,
          this.purposeRdvForm.controls.heureRdv.value,
          this.id_client,
          this.purposeRdvForm.controls.avocatRdv.value,
          this.purposeRdvForm.controls.rdvTypeSelected.value,
        ).toPromise().then((res) => {
          if (this.id_client != "") {
            this.getRdvByIdClient();
            this.getBalance()
          } else {
            this.getRdvByIdAvocat();
            this.getBalance()

          }
        })
        this.error_heure = ""
      }
      if (res.length > 0) {
        Swal.fire({
          'text': "erreur : votre avocat as déja un rendez-vous cette heure ci",
          'icon': "error"
        })
      } else {
        Swal.fire({
          'text': "Votre rendez-vous as bien étais proposer",
          'icon': "success"
        })
      }
    }).catch((err) => {

    });
  }

  validerRdv(rdv: any) {
    this.postService.validerRdv(rdv).toPromise().then((res) => {
      if (this.id_client != "") {
        this.getRdvByIdClient();
        this.getBalance()
      } else {
        this.getRdvByIdAvocat();
        this.getBalance()
      }
    })
  }
  refuserRdv(rdv: any) {
    this.postService.refuserRdv(rdv).toPromise().then((res) => {
      if (this.id_client != "") {
        this.getRdvByIdClient()
        this.getBalance()
      } else {
        this.getRdvByIdAvocat()
        this.getBalance()
      }
    })
  }

  redirectFacture(rdv: any) {
    this.router.navigate(['/facture/' + rdv.id])
  }

  resetFilters() {
    if (this.id_client != "") {
      this.getRdvByIdClient();
      this.getBalance()
    } else {
      this.getRdvByIdAvocat()
      this.getBalance()
    }
  }

  getAllRdvByStatus(status: number) {
    if (this.id_client != "") {
      this.getAllRdvByStatusAndClient(status, this.id_client);
      this.getBalance()
    } else {
      this.getAllRdvByStatusAndAvocat(status, this.id_avocat);
      this.getBalance()
    }
  }

  getAllRdvByStatusAndClient(status: number, id_client: number) {
    this.getService.getAllRdvByStatusAndClient(status, id_client).toPromise().then((res: any) => {
      if (res.length == 0) {
        Swal.fire({
          'text': "il n'y as pas de rendez-vous avec status",
          'icon': "error"
        }).then((res) => {
          this.rdvs = [];
        })
      } else {
        this.rdvs = [];
        this.rdvs = res
      }
    })
  }

  getAllRdvByStatusAndAvocat(status: number, id_avocat: number) {
    this.getService.getAllRdvByStatusAndAvocat(status, id_avocat).toPromise().then((res: any) => {
      if (res.length == 0) {
        Swal.fire({
          'text': "il n'y as pas de rendez-vous avec status",
          'icon': "error"
        }).then((res) => {
          this.rdvs = [];
        })
      } else {
        this.rdvs = [];
        this.rdvs = res
      }
    })
  }

  getAllRdvByStatusFacture() {
    if (this.id_client != "") {
      this.getAllRdvByStatusFacturesAndClient(this.id_client);
      this.getBalance()
    } else {
      this.getAllRdvByStatusFacturesAndAvocat(this.id_avocat);
      this.getBalance()
    }
  }

  getAllRdvByStatusFacturesAndClient(id_client: string) {
    if (this.selectedOption === 'statusFacture') {
      this.getService.getRdvByIdClient(id_client).toPromise().then((res: any) => {
        this.rdvs = [];
        for (let i = 0; i < res.length; i++) {
          if (res[i].statusFacture === "pas de facture") {
            this.rdvs.push(res[i]);
          } else if (res[i].statusFacture != "pas de facture") {

          }
        }
      })
    }
    if (this.selectedOption != 'statusFacture') {
      if (this.id_client != "") {
        this.getRdvByIdClient()
      } else {
        this.getRdvByIdAvocat()
      }
    }
  }

  getAllRdvByStatusFacturesAndAvocat(id_avocat: string) {
    this.getService.getRdvByIdAvocat(id_avocat).toPromise().then((res: any) => {
      for (let i = 0; i < res.length; i++) {
        if (res[i].statusFacture != "pas de facture") {
          Swal.fire({
            'text': "il n'y as pas de rendez-vous qui n'ont pas de factures",
            'icon': "error"
          }).then((res) => {
            this.rdvs = [];
          })
        } else {
          this.rdvs = [];
          this.rdvs = res
        }
      }
    })
  }
    //balance 
    balance: any;

    isPositive(montant: number) {
      if (montant > 0) {
        return true
      } else {
        return false;
      }
    }
    
    getBalance() {
      if (this.id_client != "") {
        this.getService.getBalanceByClient(this.id_client).toPromise().then((res: any) => {
          this.balance = res      
          this.client_nom = res.client.nom;
          this.montant  = res.montant
        })
      } else {
        this.getService.getBalanceByAvocat(this.id_avocat).toPromise().then((res: any) => {
          this.balance = res
          this.avocat_nom = res.avocat.nom
          this.montant  = res.montant
        })
      }
    }
  
    addMontant(oldMontant:number, montantToAdd: number) {
      const new_montant = oldMontant + montantToAdd
      if (this.id_client != "") {
        this.postService.postNewMontantClient(this.id_client, this.balance.id, new_montant).toPromise().then((res: any) => {
          this.getBalance()
        })
      } else {
        this.postService.postNewMontantAvocat(this.id_avocat, this.balance.id, new_montant).toPromise().then((res: any) => {
          this.getBalance()
        })
      }
    }
}
