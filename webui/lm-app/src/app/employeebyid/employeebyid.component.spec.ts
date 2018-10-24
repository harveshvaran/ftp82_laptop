import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeebyidComponent } from './employeebyid.component';

describe('EmployeebyidComponent', () => {
  let component: EmployeebyidComponent;
  let fixture: ComponentFixture<EmployeebyidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeebyidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeebyidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
