import { Component } from '@angular/core';
import { UserRegistrationRequest } from '../model/UserRegistrationRequest'
import { SignUpService } from './sign-up.service'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  userRegistrationRequest: UserRegistrationRequest = new UserRegistrationRequest();

  constructor(private signUpService: SignUpService) {}

  signUp() {
    this.signUpService.signUp(this.userRegistrationRequest).subscribe();
  }
}
