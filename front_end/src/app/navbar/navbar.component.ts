import { Component } from '@angular/core';
import { NavbarService } from './navbar.service'
import { LoginService } from '../login/login.service'
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  adminRoleName = 'ADMIN'

  constructor(private navbarService: NavbarService, private loginService: LoginService, private toastr: ToastrService) {}

  loggedUserHasRole(roleName: string) {
    return this.loginService.isLoggedUserHasRole(roleName);
  }

  logOut() {
    localStorage.removeItem("token");
    this.toastr.success("Wylogowano")
  }
}
