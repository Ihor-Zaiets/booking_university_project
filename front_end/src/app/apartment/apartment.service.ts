import { Injectable } from '@angular/core';
import { BasicUrlLink } from '../BasicUrlLink';
import { Observable } from 'rxjs';
import { WebApiService } from '../Service/web-api.service';
import { Apartment } from '../model/Apartment';

const apiUrl = BasicUrlLink.basicLink + '/api/Apartment';

const httpLink = {
  searchAllApartments: apiUrl + '/searchAll',
  createAllApartments: apiUrl + '/createAll',
  editAllApartments: apiUrl + '/editAll',
  deleteAllApartments: apiUrl + '/deleteAll'
};

@Injectable({
  providedIn: 'root',
})
export class ApartmentService {
  constructor(private webApiService: WebApiService) {}

  getAllApartments(): Observable<any> {
    return this.webApiService.get(httpLink.searchAllApartments);
  }

  createAllApartments(requestBody: Apartment[]): Observable<any> {
    return this.webApiService.post(httpLink.createAllApartments, requestBody);
  }

  editAllApartments(requestBody: Apartment[]): Observable<any> {
    return this.webApiService.patch(httpLink.editAllApartments, requestBody);
  }

  deleteAllApartments(requestBody: number[]): Observable<any> {
    return this.webApiService.delete(httpLink.deleteAllApartments, requestBody);
  }
}
