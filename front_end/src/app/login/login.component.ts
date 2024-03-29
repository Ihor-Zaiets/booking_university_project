import { Component } from '@angular/core';
import { RouteService } from '../Service/route.service'
import { ToastrService } from 'ngx-toastr'
import { AuthService } from '../Service/auth.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginRequest: {login:string; password:string;} = {login: '', password: ''}

  constructor(private loginService: AuthService, private route: RouteService, private toastr: ToastrService) {}

  login() {
    this.loginService.login(this.loginRequest).subscribe((requestBody) => {
      localStorage.setItem("token", requestBody.body.token);
      this.route.reloadComponent(false, '/start');
      this.toastr.success('Zalogowano');
    });
  }
}
