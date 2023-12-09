import { Component } from '@angular/core';
import { User } from '../model/User'
import { NavbarService } from './navbar.service'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  loggedUser!: User;
  adminRoleName = 'ADMIN'

  constructor(private navbarService: NavbarService) {}

  getLoggedUser() {
    this.navbarService.getLoggerUser().subscribe((response) => {
      console.log('response.body: ', response.body)
      this.loggedUser = response.body;
    });
  }

  loggedUserHasRole(roleName: string) {
    console.log('logged user on userHasRole: ', this.loggedUser)
    console.log('this.loggedUser != null = ', this.loggedUser != null)
    console.log('this.loggedUser != null && this.loggedUser.roles != null = ', this.loggedUser != null && this.loggedUser.roles != null)
    if (this.loggedUser != null && this.loggedUser.roles != null) {
      return this.loggedUser!.roles.map(role => {
        return role.name
      }).includes(roleName)
    }
    return false
  }
}
