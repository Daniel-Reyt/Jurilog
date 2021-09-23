import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RdvComponent } from './rdv.component';
import {RouterTestingModule} from "@angular/router/testing";
import {ActivatedRoute, convertToParamMap, Router} from "@angular/router";
import {of} from "rxjs";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";

describe('RdvComponent', () => {
  let component: RdvComponent;
  let fixture: ComponentFixture<RdvComponent>;

  const ActivatedRouteSpy = {
    snapshot: {
      paramMap: convertToParamMap({
        some: 'some',
        else: 'else',
      })
    },
    queryParamMap: of(
      convertToParamMap({
        some: 'some',
        else: 'else',
      })
    )
  };

  const RouterSpy = jasmine.createSpyObj(
    'Router',
    ['navigate']
  );

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        BrowserModule,
        HttpClientModule,
        ReactiveFormsModule,
        FormsModule,
        BrowserAnimationsModule,
        MatFormFieldModule,
        MatDatepickerModule,
        MatNativeDateModule
      ],
      declarations: [ RdvComponent ],
      providers: [
        { provide: ActivatedRoute,   useValue: ActivatedRouteSpy    },
        { provide: Router,           useValue: RouterSpy            }
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RdvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
