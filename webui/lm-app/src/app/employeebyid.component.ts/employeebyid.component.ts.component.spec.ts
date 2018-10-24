import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Employeebyid.Component.TsComponent } from './employeebyid.component.ts.component';

describe('Employeebyid.Component.TsComponent', () => {
  let component: Employeebyid.Component.TsComponent;
  let fixture: ComponentFixture<Employeebyid.Component.TsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Employeebyid.Component.TsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Employeebyid.Component.TsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
