import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { EmployeeService} from '../employee.service';
import { Employee} from 'src/app/employee';
@Component({
  selector: 'app-employeebyid',
  templateUrl: './employeebyid.component.html',
})
@Injectable()
export class EmployeebyidComponent implements OnInit {
  EmployeeByIddetails: Employee;
  constructor(private emp:EmployeeService) { }

  ngOnInit(): void {

  }
  empById: Employee;

  displayEmployeeById(obj:any): void{
    console.log(obj)
    this.emp.getdisplayEmployeeById(obj).subscribe(data=>this.empById=data,err=>console.log(err));

  }
}
