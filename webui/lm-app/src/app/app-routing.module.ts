import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { SuccessComponent } from './success/success.component';
import { FailureComponent } from './failure/failure.component';

const routes: Routes = [
  {path:"login", component:LoginComponent},
  {path:"aboutus", component:AboutusComponent},
  {path:"contactus", component:ContactusComponent},
  {path:'', redirectTo:"login", pathMatch:"full"},
  {path:'success', component:SuccessComponent},
  {path:'failure', component:FailureComponent},
  {path:"**", component:NotfoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
