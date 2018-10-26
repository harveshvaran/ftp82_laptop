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
  constructor() { 
  }

  title = 'Leave Management Application';
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
