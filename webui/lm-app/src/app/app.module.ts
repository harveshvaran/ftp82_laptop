import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { PendingComponent } from './pending.component';
import { AppComponent } from './app.component';
import { LeaveDetailsService } from 'src/app/leaveDetailsService';
import { EmployeeService } from './employee.service';
import { FormsModule } from '@angular/forms'
import { EmployeebyidComponent } from './employeebyid/employeebyid.component';

@NgModule({
  declarations: [
    AppComponent,
    PendingComponent,
    EmployeebyidComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule
  ],
  providers: [LeaveDetailsService,EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
