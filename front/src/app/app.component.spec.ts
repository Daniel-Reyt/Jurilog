import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { url } from 'src/main';
import { AppComponent } from './app.component';
import {NavbarComponent} from "./navbar/navbar.component";

describe('AppComponent', () => {
  let http: HttpClient;
  let clients: [any] = <any>[];


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientModule
      ],
      declarations: [
        AppComponent,
        NavbarComponent
      ]
    }).compileComponents();

    http = TestBed.inject(HttpClient);
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should get clients', (done) => {
    http.get("http://localhost:8888/clients").subscribe((res: any) => {
      expect(res.length).toBe(2);
      done()
    })
  });

  it('should get avocats', (done) => {
    http.get("http://localhost:8888/avocats").subscribe((res: any) => {
      expect(res.length).toBe(2)
      done()
    })
  });
  it('should get rdvs', (done) => {
    http.get("http://localhost:8888/rdvs").subscribe((res: any) => {
      expect(res.length).toBe(3)
      done()
    })
  });
  it('should get factures', (done) => {
    http.get("http://localhost:8888/factures").subscribe((res: any) => {
      expect(res.length).toBe(3)
      done()
    })
  });

  it('should not get client', (done) => {
    http.get("http://localhost:8888/client/" + 3).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });
  it('should not get avocat', (done) => {
    http.get("http://localhost:8888/avocat/" + 3).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });
  it('should not get facture', (done) => {
    http.get("http://localhost:8888/facture/" + 4).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });
  it('should not get rdv', (done) => {
    http.get("http://localhost:8888/rdv/" + 4).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });

  it('should update and calculate total facture', (done) => {
    http.get("http://localhost:8888/rdv/" + 3).toPromise().then((resRdv) => {
      http.put("http://localhost:8888/facture", {
        id: 3,
        nbHeure: 1,
        tauxHonoraire: 150,
        rdv: resRdv
      }).toPromise().then(() => {
        http.get("http://localhost:8888/facture/" + 3).subscribe((res: any) => {
          console.log(res)
          expect(res.totalFacture).toEqual(157.5)
          done()
        })
      })
    })
  });
});
  