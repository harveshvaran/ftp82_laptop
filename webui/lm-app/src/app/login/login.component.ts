import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg:string;
  constructor(private router:Router) { }

  ngOnInit() {
  }
  
  validate(obj):void {
    let user:string ="Raju";
    let pass:string ="123";


    console.log(obj)
    if(obj.user =="" || obj.pass == "") {
      {{this.msg="enter username and Password!"}}
    } else {
      if(obj.user == user && obj.pass == pass) {
        this.router.navigate(['/success']);
      } else {
        this.router.navigate(['/failure']);
      }
    }

    
  }
}
