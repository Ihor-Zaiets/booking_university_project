import { Component } from '@angular/core';
import { NavbarService } from './navbar.service'
import { AuthService } from '../Service/auth.service'
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  adminRoleName = 'ADMIN'

  constructor(private navbarService: NavbarService, private authService: AuthService, private toastr: ToastrService) {}

  loggedUserHasRole(roleName: string) {
    return this.authService.isLoggedUserHasRole(roleName);
  }

  isUserLogged() {
    return this.authService.isUserLogged();
  }

  logOut() {
    localStorage.removeItem("token");
    this.toastr.success("Wylogowano")
  }
}
