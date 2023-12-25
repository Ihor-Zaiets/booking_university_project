export class ReservationUpdateRequest {
  id!:number;
  apartmentId!:number;
  userId!:number;
  startDate!:string;
  endDate!:string;
  numberOfPeople!:number;
  price!:number;
  reservationStatus!:string;
  isUserLogged!:boolean;
  userFirstName!:string;
  userPhoneNumber!:string;
  userEmail!:string;
}
