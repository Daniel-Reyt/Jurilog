import { HttpClient, HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
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

  it('should get clients', () => {
    http.get("http://localhost:8888/clients").subscribe((res: any) => {
      expect(res.length).toBe(2)
    })
  });

  it('should get avocats', () => {
    http.get("http://localhost:8888/avocats").subscribe((res: any) => {
      expect(res.length).toBe(2)
    })
  });
  it('should get rdvs', () => {
    http.get("http://localhost:8888/rdvs").subscribe((res: any) => {
      expect(res.length).toBe(3)
    })
  });
  it('should get factures', () => {
    http.get("http://localhost:8888/factures").subscribe((res: any) => {
      expect(res.length).toBe(2)
    })
  });

  it('should not get client', () => {
    http.get("http://localhost:8888/client/" + 3).subscribe((res: any) => {
      expect(res).toBe(null)
    })
  });
  it('should not get avocat', () => {
    http.get("http://localhost:8888/avocat/" + 3).subscribe((res: any) => {
      expect(res).toBe(null)
    })
  });
  it('should not get facture', () => {
    http.get("http://localhost:8888/facture/" + 3).subscribe((res: any) => {
      expect(res).toBe(null)
    })
  });
  it('should not get rdv', () => {
    http.get("http://localhost:8888/rdv/" + 4).subscribe((res: any) => {
      expect(res).toBe(null)
    })
  });
});
  