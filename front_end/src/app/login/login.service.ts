import { BasicUrlLink } from '../BasicUrlLink'
import { Injectable } from '@angular/core'
import { WebApiService } from '../Service/web-api.service'
import { UserRegistrationRequest } from '../model/UserRegistrationRequest'

const apiUrl = BasicUrlLink.basicLink + '/api/Auth'

const httpLink = {
  login: apiUrl + '/login',
}

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  constructor(private webApiService: WebApiService) {}

  login(requestBody: {login:string, password:string}) {
    return this.webApiService.post(httpLink.login, requestBody);
  }

  isUserLogged() {

  }
}
