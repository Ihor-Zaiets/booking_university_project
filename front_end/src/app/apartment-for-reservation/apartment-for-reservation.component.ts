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
  startDate!: string;
  endDate!: string;
  userFirstName!: string;
  userPhoneNumber!: string;
  numberOfPeople!: number;
  user!: User;

  doReservation() {
    let reservationUpdateRequest = new ReservationUpdateRequest()
    if (this.isUserLogged()) {
      reservationUpdateRequest.userId = this.user.id;
    }
    reservationUpdateRequest.apartmentId = this.apartmentForReservation.id;
    reservationUpdateRequest.price = this.apartmentForReservation.rentPrice;
    reservationUpdateRequest.startDate = this.startDate;
    reservationUpdateRequest.endDate = this.endDate;
    reservationUpdateRequest.numberOfPeople = this.numberOfPeople;
    reservationUpdateRequest.reservationStatus = ReservationStatus.ACTIVE.toString();
    reservationUpdateRequest.isUserLogged = this.isUserLogged();
    reservationUpdateRequest.userFirstName = this.userFirstName;
    reservationUpdateRequest.userPhoneNumber = this.userPhoneNumber;
    this.apartmentForReservationService.makeReservation(reservationUpdateRequest).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano');
    });
  }

  private isUserLogged() {
    return false;
  }
}
