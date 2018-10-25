import { Component } from '@angular/core';
import { LeaveDetails } from './LeaveDetails';
import { LeaveDetailsService } from './leaveDetailsService';

@Component({
    selector: 'history',
    templateUrl: './history.component.html',
    styleUrls: ['./app.component.css'],
    providers: [ LeaveDetailsService ]
  })

export class HistoryComponent {
    constructor(private history: LeaveDetailsService) { }
    lea:LeaveDetails[];
      title = 'Leave Management Application';
      leavehistory: LeaveDetails[]; 
      getHistory(obj1:any) {
          this.history.load(obj1).
          subscribe(
              data=>this.lea=data,
              error=>console.log(error),
              ()=>console.log("Success!!")
          );
      }

}