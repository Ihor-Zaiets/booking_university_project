import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { AppComponent } from './app.component'
import { ApartmentComponent } from './apartment/apartment.component'

const routes: Routes = [
  { path: '', component: AppComponent },
  { path: 'user', component: UserComponent },
  { path: 'apartment', component: ApartmentComponent },
  // Add other routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
