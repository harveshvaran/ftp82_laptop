import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg:string;
  user:string;
  constructor(private router:Router) { }

  ngOnInit() {
    this.user = localStorage.getItem("Sid");
    console.log(this.user);
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
