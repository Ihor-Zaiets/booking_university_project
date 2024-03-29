import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { AppComponent } from './app.component'
import { ApartmentComponent } from './apartment/apartment.component'
import { LoginComponent } from './login/login.component'
import { SignUpComponent } from './sign-up/sign-up.component'
import { StartComponent } from './start/start.component'
import { ApartmentForReservationComponent } from './apartment-for-reservation/apartment-for-reservation.component'
import { UserProfileComponent } from './user-profile/user-profile.component'

const routes: Routes = [
  { path: '', redirectTo: '/start', pathMatch: 'full' },
  { path: 'user', component: UserComponent },
  { path: 'apartment', component: ApartmentComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signUp', component: SignUpComponent },
  { path: 'start', component: StartComponent },
  { path: 'apartmentForReservation', component: ApartmentForReservationComponent },
  { path: 'userProfile', component: UserProfileComponent },
  // Add other routes as needed
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
