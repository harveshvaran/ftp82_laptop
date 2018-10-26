import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SharedService } from '../sharedservice';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg:string;
  constructor(private router:Router,private sharedService:SharedService) { }
  empId:number;
  ngOnInit() {
    this.empId=this.sharedService.getId();
  }
  
  validate(obj):void {

    let pass:string ="123";

    console.log(pass);
    console.log(obj);

     if(obj.pass == "") {
       {{this.msg="enter username and Password!"}}
     } else {
       if(obj.pass == pass) {
         this.router.navigate(['/dashboard']);
       }
     }

    
  }
}
