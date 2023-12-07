import { Injectable } from '@angular/core';
import { WebApiService } from '../Service/web-api.service'
import { BasicUrlLink } from '../BasicUrlLink'
import { UserRegistrationRequest } from '../model/UserRegistrationRequest'

const apiUrl = BasicUrlLink.basicLink + '/api/Auth'

const httpLink = {
  signUp: apiUrl + '/signup',
}

@Injectable({
  providedIn: 'root'
})
export class SignUpService {

  constructor(private webApiService: WebApiService) {}

  signUp(requestBody: UserRegistrationRequest) {
    console.log('webapi ', requestBody)
    return this.webApiService.post(httpLink.signUp, requestBody);
  }
}
