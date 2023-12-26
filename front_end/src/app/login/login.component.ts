import { Component } from '@angular/core';
import { RouteService } from '../Service/route.service'
import { ToastrService } from 'ngx-toastr'
import { LoginService } from './login.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginRequest: {login:string; password:string;} = {login: '', password: ''}

  constructor(private loginService: LoginService, private route: RouteService, private toastr: ToastrService) {}

  login() {
    this.loginService.login(this.loginRequest).subscribe((requestBody) => {
      console.log(requestBody)
      this.route.reloadComponent(false, '/start');
      this.toastr.success('Zalogowano');
    });
  }
}
