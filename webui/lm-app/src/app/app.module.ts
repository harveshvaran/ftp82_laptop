import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'

import { LeaveDetailsService } from './leaveDetailsService';
import { EmployeeService } from './employee.service';

import { AppComponent } from './app.component';

import { LoginComponent } from './login/login.component';
import { ContactusComponent } from './contactus/contactus.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { SuccessComponent } from './success/success.component';
import { FailureComponent } from './failure/failure.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AppRoutingModule } from './app-routing.module';

import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';

import { PendingComponent } from './pending/pending.component';
import { EmployeebyidComponent } from './employeebyid/employeebyid.component';

import { DeleteComponent } from './delete/delete.component';
import { HistoryComponent } from './history/history.component';
import { UpdateComponent } from './update/update.component';

import { ApproveDenyComponent } from './approveOrDeny/approveOrDeny.component';
import { EditApproveDenyComponent } from './editPermission/editPermission.component';
import { ApplyleaveComponent } from './applyleave/applyleave.component';
import { SharedService } from './sharedservice';


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
    DeleteComponent,
    HomeComponent,
    DashboardComponent,
    ApplyleaveComponent,
    HistoryComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,AppRoutingModule
  ],
  providers: [LeaveDetailsService,EmployeeService,SharedService],
  bootstrap: [AppComponent]
})
export class AppModule { }
