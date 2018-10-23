import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LeaveDetailsService } from 'src/app/leaveDetailsService';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,HttpClientModule
  ],
  providers: [LeaveDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
