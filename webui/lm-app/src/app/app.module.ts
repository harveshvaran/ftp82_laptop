import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'

import { LeaveDetailsService } from './leaveDetailsService';
import { EmployeeService } from './employee.service';

import { AppComponent } from './app.component';
import { PendingComponent } from './pending/pending.component';
import { EmployeebyidComponent } from './employeebyid/employeebyid.component';

import { DeleteComponent } from './delete/delete.component';
import { HistoryComponent } from './history/history.component';
import { UpdateComponent } from './update/update.component';

import { ApproveDenyComponent } from './approveOrDeny/approveOrDeny.component';
import { EditApproveDenyComponent } from './editPermission/editPermission.component';
import { ApplyleaveComponent } from './applyleave/applyleave.component';


@NgModule({
  declarations: [
    AppComponent,
    PendingComponent,
    EmployeebyidComponent,
    DeleteComponent,
    HistoryComponent,
    UpdateComponent,
    ApproveDenyComponent,
    EditApproveDenyComponent,
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,
    ApplyleaveComponent
  ],
  providers: [LeaveDetailsService,EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
