import { Component, OnInit } from '@angular/core'
import { Apartment } from '../model/Apartment'
import { ApartmentService } from '../apartment/apartment.service'
import { ApartmentForReservationService } from '../apartment-for-reservation/apartment-for-reservation.service'

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.scss']
})
export class StartComponent implements OnInit {
  apartments!: Apartment[];
  checkedApartments: Set<number> = new Set<number>();

  constructor(private apartmentService: ApartmentService, private apartmentForReservationService: ApartmentForReservationService) {}

  ngOnInit(): void {
    this.getApartmentsForUsers();
  }

  getApartmentsForUsers() {
    this.apartmentService.getApartmentsForUsers().subscribe((response) => this.apartments = response.body);
  }

  isChecked(apartmentId: number) {
    return this.checkedApartments.has(apartmentId);
  }

  setApartmentForReservation(apartment: Apartment) {
    this.apartmentForReservationService.setApartment(apartment);
  }

  onCheckboxChange(apartmentId: number) {
    if (this.checkedApartments.has(apartmentId)) {
      this.checkedApartments.delete(apartmentId);
    } else {
      this.checkedApartments.add(apartmentId);
    }
  }
}
