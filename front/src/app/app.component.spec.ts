import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import {NavbarComponent} from "./navbar/navbar.component";

describe('AppComponent', () => {
  let http: HttpClient;
  let clients: [any] = <any>[];
  let url = "http://10.3.1.58:8989/"

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
    http.get(`${url}clients`).subscribe((res: any) => {
      console.log(res)
      expect(res.length).toBe(2);
      done()
    })
  });

  it('should get avocats', (done) => {
    http.get(`${url}avocats`).subscribe((res: any) => {
      expect(res.length).toBe(2)
      done()
    })
  });
  it('should get rdvs', (done) => {
    http.get(`${url}rdvs`).subscribe((res: any) => {
      expect(res.length).toBe(4)
      done()
    })
  });
  it('should get factures', (done) => {
    http.get(`${url}factures`).subscribe((res: any) => {
      expect(res.length).toBe(4)
      done()
    })
  });

  it('should not get client', (done) => {
    http.get(`${url}client/` + 3).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });
  it('should not get avocat', (done) => {
    http.get(`${url}avocat/` + 3).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });
  it('should not get facture', (done) => {
    http.get(`${url}facture/` + 5).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });
  it('should not get rdv', (done) => {
    http.get(`${url}rdv/` + 5).subscribe((res: any) => {
      expect(res).toEqual(null)
      done()
    })
  });

  it('should update and calculate total facture', () => {
    var result = (150*1) + ((150*1) * (5/100))
    expect(result).toBe(157.5)
  });
});
  