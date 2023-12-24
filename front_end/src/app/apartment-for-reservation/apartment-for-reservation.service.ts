import { Injectable } from '@angular/core';
import { Apartment } from '../model/Apartment'

@Injectable({
  providedIn: 'root'
})
export class ApartmentForReservationService {

  constructor() { }

  apartmentForReservation = new Apartment();

  setApartment(apartment: Apartment) {
    this.apartmentForReservation = apartment;
  }

  getApartment() {
    return this.apartmentForReservation;
  }
}
