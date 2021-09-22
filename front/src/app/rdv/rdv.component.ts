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
  width: any;
  collapseNavBarSmall: boolean = true;
  selectedOption: any = "Id";

  filtreByDate: any;
  filtreByIdRdv: any;

  rdvs: any;
  rdv: any;

  purposeRdvForm!: FormGroup;
  avocat: any;
  avocats: any;

  id_client: any;
  constructor(private fb: FormBuilder,
              private router: Router,
              private getService: GetService,
              private postService: PostService) { }

  ngOnInit(): void {
    this.width = window.innerWidth;

    this.getRdvs();

    this.getService.getAllAvocats().toPromise().then((res: any) => {
      this.avocats = res
    });

    this.purposeRdvForm = this.fb.group({
      dateRdv: '',
      heureRdv: '',
      avocatRdv: ''
    })

    this.id_client = localStorage.getItem('id_client')
  }
  @HostListener('window:resize', ['$event'])
  onResize(event: Event) {
    this.width = window.innerWidth;
  }

  setCollapseNavBarSmall() {
    if (this.collapseNavBarSmall == true) {
      this.collapseNavBarSmall = false
    } else {
      this.collapseNavBarSmall = true
    }
  }

  private getRdvs() {
    this.getService.getAllRdvs().toPromise().then((resRdv: any) => {
      this.rdvs = resRdv
      for (let i = 0; i < resRdv.length; i++) {
        this.getService.getFactureByRdv(resRdv[i].id).toPromise().then((resFactures: any) => {
              if (resFactures == null) {
                resRdv[i].status_facture = 'pas de facture'
              } else {
                if (resFactures.status_facture === 0) {
                  resRdv[i].status_facture = "a payer"
                }
                if (resFactures.status_facture === 1) {
                  resRdv[i].status_facture = "payer"
                }
              }
            })
            if (resRdv[i].status == 0) {
              resRdv[i].status = "en attente"
            }
            if (resRdv[i].status == 1) {
              resRdv[i].status = "approuvé"
            }
            if (resRdv[i].status == 2) {
              resRdv[i].status = "refusé"
            }
          }
    });
  }

  getRdvByDate() {
    this.getService.getRdvByDate(this.filtreByDate).toPromise().then((res: any) => {
      if (res == null) {
        this.getRdvs();
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
  }

  getRdvById() {
    if (this.filtreByIdRdv != null) {
      this.getService.getRdvById(this.filtreByIdRdv).toPromise().then((res: any) => {
        if (res == null) {
          this.getRdvs();
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
          this.rdv = res
          this.rdvs = [];
          this.rdvs.push(this.rdv)
        }
      })
    }
  }

  submitRdv() {
    this.postService.postRdv(
      this.purposeRdvForm.controls.dateRdv.value,
      this.purposeRdvForm.controls.heureRdv.value,
      this.id_client,
      this.purposeRdvForm.controls.avocatRdv.value).toPromise().then((res) => {
        this.getRdvs()
    })
  }

  validerRdv(rdv: any) {
    this.postService.validerRdv(rdv).toPromise().then((res) => {
      this.getRdvs()
    })
  }
  refuserRdv(rdv: any) {
    this.postService.refuserRdv(rdv).toPromise().then((res) => {
      this.getRdvs()
    })
  }

  redirectFacture(rdv: any) {
      this.router.navigate(['/facture/' + rdv.id])
  }
}
