import { Component } from '@angular/core';
import { User } from '../model/User'

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent {

  user = new User();

  saveUser() {

  }
}
