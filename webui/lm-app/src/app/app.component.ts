import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ EmployeeService]
})
export class AppComponent implements OnInit {
  constructor(private employeeService: EmployeeService) { 
    this.employeeService.getEmployees().subscribe(data=>console.log(data),err=>console.log(err));
  }

  title = 'Leave Management Application';
  employees: Employee[];
  /*
  getEmployees(): void {
      this.employeeService.getEmployees().then(employees => {
        console.log('getEmployees promise resolved : ' + employees.length);
        this.employees = employees;
      }
      );
      
    
  }*/
  ngOnInit(): void {
  }
}
