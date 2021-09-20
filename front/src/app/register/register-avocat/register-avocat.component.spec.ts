import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterAvocatComponent } from './register-avocat.component';

describe('RegisterAvocatComponent', () => {
  let component: RegisterAvocatComponent;
  let fixture: ComponentFixture<RegisterAvocatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
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
