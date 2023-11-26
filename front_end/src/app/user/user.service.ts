import { Injectable } from '@angular/core';
import { BasicUrlLink } from '../BasicUrlLink'
import { Observable } from 'rxjs'
import { WebApiService } from '../Service/web-api.service'

const apiUrl = BasicUrlLink.basicLink + '/api/User'

const httpLink = {
  searchAllUsers: apiUrl + '/searchAll',
  createAllUsers: apiUrl + '/createAll',
  editAllUsers: apiUrl + '/editAll',
  deleteAllUsers: apiUrl + '/deleteAll'
}

@Injectable({
  providedIn: 'root',
})

export class UserService {
  constructor(private webApiService: WebApiService) {}

  getData() {
    return this.webApiService.get(httpLink.searchAllUsers);
  }

  postData(requestBody: any): Observable<any> {
    return this.webApiService.post(httpLink.createAllUsers, requestBody);
  }

  patchData(requestBody: any): Observable<any> {
    return this.webApiService.patch(httpLink.editAllUsers, requestBody);
  }

  deleteData(requestBody: any): Observable<any> {
    return this.webApiService.delete(httpLink.deleteAllUsers, requestBody);
  }
}
