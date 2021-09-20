import {Component, HostListener, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DatePipe} from "@angular/common";

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
  private rdv: any;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.width = window.innerWidth;

    this.http.get('http://localhost:8888/rdvs').toPromise().then((res: any) => {
      console.log(res)
      this.rdvs = res
    })
  }

  @HostListener('window:resize', ['$event'])
  onResize(event: Event) {
    this.width = window.innerWidth;
  }

  setCollapseNavBarSmall() {
    if (this.collapseNavBarSmall == true) {
      this.collapseNavBarSmall = false
      console.log(this.collapseNavBarSmall)
    } else {
      this.collapseNavBarSmall = true
      console.log(this.collapseNavBarSmall)
    }
  }

  getRdvByDate() {
    if (this.filtreByDate != null) {
      var date = new Date(this.filtreByDate);
      this.http.get('http://localhost:8888/rdvByDate/' + date).toPromise().then((res: any) => {
        console.log(res)
        if (res == null) {
          this.http.get('http://localhost:8888/rdvs').toPromise().then((res: any) => {
            console.log(res)
            this.rdvs = res
          })
        }
        this.rdv = res
        this.rdvs = [];
        this.rdvs.push(this.rdv)
      })
    }
  }

  getRdvById() {
    if (this.filtreByIdRdv != null) {
      this.http.get('http://localhost:8888/rdv/' + this.filtreByIdRdv).toPromise().then((res: any) => {
        console.log(res)
        if (res == null) {
          this.http.get('http://localhost:8888/rdvs').toPromise().then((res: any) => {
            console.log(res)
            this.rdvs = res
          })
        }
        this.rdv = res
        this.rdvs = [];
        this.rdvs.push(this.rdv)
      })
    }
  }
}
