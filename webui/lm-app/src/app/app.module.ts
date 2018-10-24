import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LeaveDetailsService } from 'src/app/leaveDetailsService';
import { PendingComponent } from './pending.component';

@NgModule({
  declarations: [
    AppComponent,
    PendingComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule
  ],
  providers: [LeaveDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
