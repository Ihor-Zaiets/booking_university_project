import { Component } from '@angular/core';
import { Apartment } from '../model/Apartment'
import { ApartmentForReservationService } from './apartment-for-reservation.service'

@Component({
  selector: 'app-apartment-for-reservation',
  templateUrl: './apartment-for-reservation.component.html',
  styleUrls: ['./apartment-for-reservation.component.scss']
})
export class ApartmentForReservationComponent {

  constructor(private apartmentForReservationService: ApartmentForReservationService) { }

  apartmentForReservation = this.apartmentForReservationService.getApartment();

  doReservation() {

  }


}
