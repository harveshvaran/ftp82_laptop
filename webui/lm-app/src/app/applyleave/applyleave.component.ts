import { Component, OnInit } from '@angular/core';
import {LeaveDetailsService} from '../leaveDetailsService';
import {LeaveDetails} from '../LeaveDetails';

@Component({
  selector: 'app-applyleave',
  templateUrl: './applyleave.component.html',
  styleUrls: ['./applyleave.component.css']
})
export class ApplyleaveComponent implements OnInit {

  constructor(private ls:LeaveDetailsService) { }
  apply:LeaveDetails;
  
  ngOnInit() {
  }
applyLeave(app:any):void {
  console.log(app);
  
  this.ls.leaveApply(app).subscribe(data=>this.apply=data,err=>console.log(err));
  
}
}
