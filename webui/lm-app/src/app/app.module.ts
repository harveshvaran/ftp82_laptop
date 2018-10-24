import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LeaveDetailsService } from 'src/app/leaveDetailsService';
import { EmployeebyidComponent } from './employeebyid/employeebyid.component';
import { EmployeeService } from './employee.service';
import { FormsModule } from '@angular/forms'

@NgModule({
  declarations: [
    AppComponent,
    EmployeebyidComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule
  ],
  providers: [LeaveDetailsService,EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
