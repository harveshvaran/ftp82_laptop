import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { PendingComponent } from './pending.component';
import { AppComponent } from './app.component';
import { LeaveDetailsService } from 'src/app/leaveDetailsService';
import { EmployeeService } from './employee.service';
import { FormsModule } from '@angular/forms'
import { EmployeebyidComponent } from './employeebyid/employeebyid.component';
import { DeleteComponent } from './delete/delete.component';
import { HistoryComponent } from './history.component';
import { UpdateComponent } from './update/update.component';


@NgModule({
  declarations: [
    AppComponent,
    PendingComponent,
    EmployeebyidComponent,
    DeleteComponent,
    HistoryComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule
  ],
  providers: [LeaveDetailsService,EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
