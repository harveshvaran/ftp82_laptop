import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Employeebyid.TsComponent } from './employeebyid.ts.component';

describe('Employeebyid.TsComponent', () => {
  let component: Employeebyid.TsComponent;
  let fixture: ComponentFixture<Employeebyid.TsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Employeebyid.TsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Employeebyid.TsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
