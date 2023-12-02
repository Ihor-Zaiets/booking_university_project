import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app-routing.module';
import { ApartmentComponent } from './apartment/apartment.component'
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms'
import { ToastrModule } from 'ngx-toastr'
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'

const toastrConfiguration = {
  timeOut: 3000,
  tapToDismiss: true,
  positionClass: 'toast-bottom-center',
}

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ApartmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    [HttpClientModule],
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(toastrConfiguration),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
