import { Injectable } from '@angular/core';
import { BasicUrlLink } from '../BasicUrlLink'
import { Observable } from 'rxjs'
import { WebApiService } from '../Service/web-api.service'
import { User } from '../model/User'

const apiUrl = BasicUrlLink.basicLink + '/api/User'

const httpLink = {
  searchAllUsers: apiUrl + '/searchAll',
  createAllUsers: apiUrl + '/createAll',
  editAllUsers: apiUrl + '/editAll',
  deleteAllUsers: apiUrl + '/deleteAll',
  getUserDataForReservation: apiUrl + '/userDataForReservation/'
}

@Injectable({
  providedIn: 'root',
})

export class UserService {
  constructor(private webApiService: WebApiService) {}

  getAllUsers() {
    return this.webApiService.get(httpLink.searchAllUsers);
  }

  createAllUsers(requestBody: User[]): Observable<any> {
    return this.webApiService.post(httpLink.createAllUsers, requestBody);
  }

  editAllUsers(requestBody: User[]): Observable<any> {
    return this.webApiService.patch(httpLink.editAllUsers, requestBody);
  }

  deleteAllUsers(requestBody: number[]): Observable<any> {
    return this.webApiService.delete(httpLink.deleteAllUsers, requestBody);
  }

  getUserDataForReservation(userId: number) {
    return this.webApiService.get(httpLink.getUserDataForReservation + userId);
  }
}
