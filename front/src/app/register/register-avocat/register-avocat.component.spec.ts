import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterAvocatComponent } from './register-avocat.component';
import {RouterTestingModule} from "@angular/router/testing";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";

describe('RegisterAvocatComponent', () => {
  let component: RegisterAvocatComponent;
  let fixture: ComponentFixture<RegisterAvocatComponent>;

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
      declarations: [ RegisterAvocatComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterAvocatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
