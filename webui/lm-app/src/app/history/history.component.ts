import { Component } from '@angular/core';
import { LeaveDetails } from '../LeaveDetails';
import { LeaveDetailsService } from '../leaveDetailsService';
import { SharedService } from '../sharedservice';

@Component({
    selector: 'history',
    templateUrl: './history.component.html'
  })

export class HistoryComponent {
    constructor(private history: LeaveDetailsService,private sharedService:SharedService) {

    }
    empId:number;
    ngOnInit() {
        this.empId=this.sharedService.getId();
    }
    lea:LeaveDetails[];
    title = 'Leave Management Application';
    leavehistory: LeaveDetails[];

    getHistory(empId:any) {
        console.log(empId+" in history ts")
        this.history.load(empId).subscribe(
            data=>this.lea=data,
            error=>console.log(error),
            ()=>console.log("Success!!")
        );
    }

}