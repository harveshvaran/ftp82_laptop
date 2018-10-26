import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { SharedService } from '../sharedservice';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  employees: Employee[];
  empId:number;
  constructor(private router:Router, 
    private employeeService: EmployeeService,
    private activateRouter:ActivatedRoute,
    private sharedService:SharedService) {

    this.activateRouter.params.subscribe(param=>this.empId=param.id);

    this.employeeService.getEmployees().subscribe(data=>this.employees=data,err=>console.log(err));
    
   }
  ngOnInit() {
    this.empId=this.sharedService.getId();
  }
  addItem(empIdRef):void {
    this.sharedService.setId(empIdRef);
    this.empId=this.sharedService.getId();
    this.router.navigate(['/login']);
  }
}
