import { Component } from '@angular/core';
import { UserRegistrationRequest } from '../model/UserRegistrationRequest'
import { SignUpService } from './sign-up.service'
import { RouteService } from '../Service/route.service'
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  userRegistrationRequest: UserRegistrationRequest = new UserRegistrationRequest();

  constructor(private signUpService: SignUpService, private route: RouteService, private toastr: ToastrService) {}

  signUp() {
    this.signUpService.signUp(this.userRegistrationRequest).subscribe(() => {
      this.route.reloadComponent(false, '/login');
      this.toastr.success('Zapisano');
    });
  }
}
