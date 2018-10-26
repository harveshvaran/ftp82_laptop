import { Component, OnInit } from '@angular/core';
import { LeaveDetailsService } from '../leaveDetailsService';
import { LeaveDetails } from '../LeaveDetails';

@Component({
  selector: 'update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private update:LeaveDetailsService) { }

  ngOnInit() {
  }
  leaveUpdate:LeaveDetails;
  updateInfo(emp:any):void {
    console.log(emp);
   this.update.putUpdate(emp).subscribe(data=>this.leaveUpdate=data,error=>console.log(error));
  }
}
