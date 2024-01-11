import { Component, OnInit } from '@angular/core'
import { User } from '../model/User'
import { ApartmentService } from '../apartment/apartment.service'
import { ApartmentForReservationService } from '../apartment-for-reservation/apartment-for-reservation.service'
import { UserService } from '../user/user.service'
import { AuthService } from '../Service/auth.service'
import { RouteService } from '../Service/route.service'
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  user = new User();

  constructor(
    private userService: UserService,
    private authService: AuthService,
    private route: RouteService,
    private toastr: ToastrService) {}

  ngOnInit(): void {
    this.userService.getUserById(this.authService.getLoggedUserId()).subscribe((response) => {
      this.user = response.body;
    });
  }

  saveUser() {
    this.userService.editAllUsers([this.user]).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano');
    });
  }
}
