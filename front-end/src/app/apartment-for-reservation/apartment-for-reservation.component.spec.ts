import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApartmentForReservationComponent } from './apartment-for-reservation.component';

describe('ApartmentForReservationComponent', () => {
  let component: ApartmentForReservationComponent;
  let fixture: ComponentFixture<ApartmentForReservationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApartmentForReservationComponent]
    });
    fixture = TestBed.createComponent(ApartmentForReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
