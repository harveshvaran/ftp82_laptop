import { Component, OnInit } from '@angular/core';
import {LeaveDetailsService} from '../leaveDetailsService';
import {LeaveDetails} from '../LeaveDetails';
@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css'],
  providers:[LeaveDetailsService]
})
export class DeleteComponent implements OnInit {
  deleteLeaveDetails:LeaveDetails;
  constructor(private del:LeaveDetailsService) { }

  ngOnInit() {
  }
  delete(obj:any): void{
    console.log(obj);
    this.del.deleteLeaveDetails(obj).subscribe(data=>this.deleteLeaveDetails=data,err=>console.log(err));
  }
}
