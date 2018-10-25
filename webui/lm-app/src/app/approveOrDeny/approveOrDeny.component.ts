import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../leaveDetailsService';

@Component({
  selector: 'app-appOrDeny',
  templateUrl: './approveOrDeny.component.html'
  })
export class ApproveDenyComponent implements OnInit {
  constructor(private leaveDetailsService:LeaveDetailsService) {

   }
  ngOnInit(): void {

  }

  msg:string;

  appOrDeny(obj:any): void {
    console.log(obj);
    if(obj.eid=="" || obj.lid =="" || obj.comments=="" || obj.status=="") {
        this.msg = "Please provide values" ;
    } else {
        this.leaveDetailsService.getAppOrDeny(obj).subscribe(data=>this.msg=data,err=>console.log(err));
    }
    
    }
}
