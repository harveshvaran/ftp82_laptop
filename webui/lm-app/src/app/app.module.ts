import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'

import { LeaveDetailsService } from 'src/app/leaveDetailsService';
import { EmployeeService } from './employee.service';

import { AppComponent } from './app.component';
import { PendingComponent } from './pending.component';
import { EmployeebyidComponent } from './employeebyid/employeebyid.component';
import { ApproveDenyComponent } from './approveOrDeny/approveOrDeny.component';
import { EditApproveDenyComponent } from './editPermission/editPermission.component';
import { LoginComponent } from './login/login.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { SuccessComponent } from './success/success.component';
import { FailureComponent } from './failure/failure.component';


@NgModule({
  declarations: [
    AppComponent,
    PendingComponent,
    EmployeebyidComponent,
    ApproveDenyComponent,
    EditApproveDenyComponent,
    LoginComponent,
    AboutusComponent,
    ContactusComponent,
    NotfoundComponent,
    SuccessComponent,
    FailureComponent,
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule
  ],
  providers: [LeaveDetailsService,EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
