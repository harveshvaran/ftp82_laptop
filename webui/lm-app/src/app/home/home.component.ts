import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  employees: Employee[];
  constructor(private router:Router, private employeeService: EmployeeService) {
    this.employeeService.getEmployees().subscribe(data=>this.employees=data,err=>console.log(err));
   }

  ngOnInit() {
  }
  addItem(empId):void {
    console.log(empId);

    localStorage.setItem( "Sid" , empId );

    this.router.navigate(['/login']);
  }
}
