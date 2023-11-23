import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app-routing.module';
import { ApartmentComponent } from './apartment/apartment.component'
import { HttpClientModule } from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    ApartmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    [HttpClientModule]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }