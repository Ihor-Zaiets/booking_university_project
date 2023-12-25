import { Injectable } from '@angular/core';
import { Apartment } from '../model/Apartment'
import { WebApiService } from '../Service/web-api.service'
import { BasicUrlLink } from '../BasicUrlLink'
import { ReservationUpdateRequest } from '../model/ReservationUpdateRequest'

const apiUrl = BasicUrlLink.basicLink + '/api/Reservation';

const httpLink = {
  makeReservation: apiUrl + '/makeReservation',
};

@Injectable({
  providedIn: 'root'
})
export class ApartmentForReservationService {

  constructor(private webApiService: WebApiService) { }

  apartmentForReservation = new Apartment();

  setApartment(apartment: Apartment) {
    this.apartmentForReservation = apartment;
  }

  getApartment() {
    return this.apartmentForReservation;
  }

  makeReservation(requestBody: ReservationUpdateRequest) {
    return this.webApiService.post(httpLink.makeReservation, requestBody);
  }
}
