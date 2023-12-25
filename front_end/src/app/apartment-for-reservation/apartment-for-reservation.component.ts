import { Component } from '@angular/core';
import { Apartment } from '../model/Apartment'
import { ApartmentForReservationService } from './apartment-for-reservation.service'
import { ReservationUpdateRequest } from '../model/ReservationUpdateRequest'
import { ReservationStatus } from '../model/ReservationStatus';
import { User } from '../model/User'
import { RouteService } from '../Service/route.service'
import { ToastrService } from 'ngx-toastr'

@Component({
  selector: 'app-apartment-for-reservation',
  templateUrl: './apartment-for-reservation.component.html',
  styleUrls: ['./apartment-for-reservation.component.scss']
})
export class ApartmentForReservationComponent {

  constructor(private apartmentForReservationService: ApartmentForReservationService, private route: RouteService, private toastr: ToastrService) { }

  apartmentForReservation = this.apartmentForReservationService.getApartment();
  reservationUpdateRequest = new ReservationUpdateRequest()
  user!: User;

  doReservation() {

    if (this.isUserLogged()) {
      this.reservationUpdateRequest.userId = this.user.id;
    }
    this.reservationUpdateRequest.apartmentId = this.apartmentForReservation.id;
    this.reservationUpdateRequest.price = this.apartmentForReservation.rentPrice;
    this.reservationUpdateRequest.reservationStatus = ReservationStatus.ACTIVE.toString();
    this.reservationUpdateRequest.isUserLogged = this.isUserLogged();
    this.apartmentForReservationService.makeReservation(this.reservationUpdateRequest).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano');
    });
  }

  private isUserLogged() {
    return false;
  }
}
