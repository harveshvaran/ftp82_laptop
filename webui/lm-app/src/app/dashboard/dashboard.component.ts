import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user:string;
  employee:Employee;

  constructor(private employeeService:EmployeeService) {
    
  }


  ngOnInit() {
    this.user = localStorage.getItem("Sid");
    this.getEmployee();
  }
  getEmployee():void {
    console.log(this.user);
    this.employeeService.getdisplayEmployeeById(this.user).subscribe(data=>this.employee=data,err=>console.log(err));
  }

}
