import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FactureComponent } from './facture.component';
import {RouterTestingModule} from "@angular/router/testing";
import {GetService} from "../service/get.service";
import {PostService} from "../service/post.service";

describe('FactureComponent', () => {
  let fixture: ComponentFixture<FactureComponent>;
  let component: FactureComponent;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        GetService,
        PostService
      ],
      declarations: [ FactureComponent ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FactureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
