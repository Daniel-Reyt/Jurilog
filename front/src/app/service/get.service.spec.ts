import { TestBed } from '@angular/core/testing';

import { GetService } from './get.service';
import {RouterTestingModule} from "@angular/router/testing";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {url} from "../../main";
import {Injectable} from "@angular/core";

describe('GetServiceService', () => {
  let service: GetService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        url,
        Injectable,
        HttpClient
      ],
    });
    service = TestBed.inject(GetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
