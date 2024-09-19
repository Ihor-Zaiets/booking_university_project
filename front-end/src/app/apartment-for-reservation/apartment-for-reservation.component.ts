import { Component, OnInit } from '@angular/core'
import { Apartment } from '../model/Apartment'
import { ApartmentForReservationService } from './apartment-for-reservation.service'
import { ReservationUpdateRequest } from '../model/ReservationUpdateRequest'
import { ReservationStatus } from '../model/ReservationStatus';
import { User } from '../model/User'
import { RouteService } from '../Service/route.service'
import { ToastrService } from 'ngx-toastr'
import { AuthService } from '../Service/auth.service'
import { UserService } from '../user/user.service'

@Component({
  selector: 'app-apartment-for-reservation',
  templateUrl: './apartment-for-reservation.component.html',
  styleUrls: ['./apartment-for-reservation.component.scss']
})
export class ApartmentForReservationComponent implements OnInit {

  constructor(
    private apartmentForReservationService: ApartmentForReservationService,
    private authService: AuthService,
    private route: RouteService,
    private toastr: ToastrService,
    private userService: UserService
  ) { }

  apartmentForReservation = this.apartmentForReservationService.getApartment();
  reservationUpdateRequest = new ReservationUpdateRequest()

  ngOnInit(): void {
    if (this.authService.isUserLogged()) {
      console.log("Ihor test: ", localStorage.getItem("token"))
      console.log("Ihor test: ", this.authService.getLoggedUserJWTPayload())
      let userId = this.authService.getLoggedUserId();
      this.userService.getUserDataForReservation(userId).subscribe((userData) => {
        this.reservationUpdateRequest.userFirstName = userData.body.firstname;
        this.reservationUpdateRequest.userEmail = userData.body.email;
        this.reservationUpdateRequest.userPhoneNumber = userData.body.phone;
      })
      this.reservationUpdateRequest.userId = userId;
    }
  }

  doReservation() {
    this.reservationUpdateRequest.apartmentId = this.apartmentForReservation.id;
    this.reservationUpdateRequest.price = this.apartmentForReservation.rentPrice;
    this.reservationUpdateRequest.reservationStatus = ReservationStatus.ACTIVE.toString();
    this.reservationUpdateRequest.isUserLogged = this.authService.isUserLogged();
    this.apartmentForReservationService.makeReservation(this.reservationUpdateRequest).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano');
    });
  }
}
