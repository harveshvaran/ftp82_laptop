import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../leaveDetailsService';
import { LeaveDetails } from '../LeaveDetails';

@Component({
  selector: 'app-reEdit',
  templateUrl: './editPermission.component.html'
})
export class EditApproveDenyComponent implements OnInit {
  constructor(private leaveDetailsService:LeaveDetailsService) {

   }
  ngOnInit(): void {

  }

  eD: LeaveDetails[];
  message:string;
  msg:string;

  editPer(obj:any): void {
    console.log(obj);
    if(obj.eid=="" || obj.lid =="" || obj.comments=="" || obj.status=="") {
        this.msg = "Please provide values" ;
    } else {
        this.leaveDetailsService.getEditPer(obj).subscribe(data=>this.msg=data,err=>console.log(err));
    }
    
    }
    editDetails(obj:any): void {
        console.log(obj);
        if(obj.eid=="") {
            this.message = "Please provide value" ;
        } else {
            this.leaveDetailsService.getEdit(obj).subscribe(data=>this.eD=data,err=>console.log(err));
        }
        
        }
}
