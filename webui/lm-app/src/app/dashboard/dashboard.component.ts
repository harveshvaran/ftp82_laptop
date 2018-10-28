import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Router } from '@angular/router';
import { SharedService } from '../sharedservice';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  employee:Employee;
  empId:number;
  constructor(private employeeService:EmployeeService, private router:Router,private sharedService:SharedService) {
    
  }


  ngOnInit() {
    this.empId=this.sharedService.getId();
    this.getEmployee();
  }
  getEmployee():void {
    console.log(this.empId);
    this.employeeService.getdisplayEmployeeById(this.empId).subscribe(data=>this.employee=data,err=>console.log(err));
  }
  getEmpHistory():void {
    this.router.navigate(['/dashboard/history']);
  }
  applyLeave():void {
    this.router.navigate(['/dashboard/applyleave']);
  }

}
