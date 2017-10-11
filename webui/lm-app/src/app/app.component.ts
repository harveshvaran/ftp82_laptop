import { Component } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from "./employee";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ EmployeeService ]
})
export class AppComponent {
  constructor(private employeeService: EmployeeService) { }

  title = 'Leave Management Application';
  employees: Employee[]
  
  getEmployees(): void {
      this.employeeService.getEmployees().then(employees => this.employees = employees);
  }

  ngOnInit(): void {
    this.getEmployees();
  }
}