import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from './leaveDetailsService';
import { LeaveDetails } from './LeaveDetails';

@Component({
  selector: 'app-pending',
  templateUrl: './pending.component.html',
  providers: [LeaveDetailsService]
})
export class PendingComponent implements OnInit {
  constructor(private leaveDetailsService:LeaveDetailsService) {

   }
  ngOnInit(): void {

  }

  pendingDetails: LeaveDetails[];
  pending(obj:any): void {
    //validation
    //null
    //wrong empid
    console.log(obj)
    this.leaveDetailsService.getPendingById(obj).subscribe(data=>this.pendingDetails=data,err=>console.log(err));
    }
}
