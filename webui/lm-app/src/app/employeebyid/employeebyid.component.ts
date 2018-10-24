import { Component, OnInit } from '@angular/core';
import { Injectable } from '@angular/core';
import { EmployeeService} from '../employee.service';
import { Employee} from 'src/app/employee';
@Component({
  selector: 'app-employeebyid',
  templateUrl: './employeebyid.component.html',
  styleUrls: ['./employeebyid.component.css']
})
@Injectable()
export class EmployeebyidComponent implements OnInit {

  constructor(private emp:EmployeeService) { }

  ngOnInit(): void {
  }
  EmployeeByIddetails: Employee;
  displayEmployeeById(obj:any): void{
    console.log(obj)
    this.emp.getdisplayEmployeeById(obj).
    subscribe(data=>this.EmployeeByIddetails=data,
      err=>console.log(err));
  }
}
