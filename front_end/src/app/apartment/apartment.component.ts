import { Component, OnInit } from '@angular/core';
import { Apartment } from '../model/Apartment';
import { RouteService } from '../Service/route.service';
import { ToastrService } from 'ngx-toastr';
import { ApartmentService } from './apartment.service'

@Component({
  selector: 'app-apartment',
  templateUrl: './apartment.component.html',
  styleUrls: ['./apartment.component.scss']
})
export class ApartmentComponent implements OnInit {
  apartments!: Apartment[];
  checkedApartments: Set<number> = new Set<number>();
  newApartments: Apartment[] = [];

  constructor(private apartmentService: ApartmentService, private route: RouteService, private toastr: ToastrService) {}

  ngOnInit(): void {
    this.getAllApartments();
  }

  getAllApartments() {
    this.apartmentService.getAllApartments().subscribe((response) => {
      console.log(response.body)
      this.apartments = response.body
      console.log(this.apartments)
    });
  }

  saveApartments() {
    this.apartmentService.createAllApartments(this.newApartments).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano');
    });
  }

  editApartments() {
    this.apartmentService.editAllApartments(this.apartments.filter((apartment) => this.checkedApartments.has(Number(apartment.id)))).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Zapisano');
    });
  }

  deleteApartments() {
    this.apartmentService.deleteAllApartments(Array.from(this.checkedApartments)).subscribe(() => {
      this.route.reloadComponent(true);
      this.toastr.success('Usunięto');
    });
  }

  isChecked(apartmentId: number) {
    return this.checkedApartments.has(apartmentId);
  }

  onCheckboxChange(apartmentId: number) {
    if (this.checkedApartments.has(apartmentId)) {
      this.checkedApartments.delete(apartmentId);
    } else {
      this.checkedApartments.add(apartmentId);
    }
  }

  reloadPage() {
    window.location.reload();
  }

  addNewApartment() {
    this.newApartments.push(new Apartment());
  }

  deleteNewApartment(index: number) {
    this.newApartments.splice(index, 1);
  }
}
