import { BasicUrlLink } from '../BasicUrlLink'
import { Injectable } from '@angular/core'
import { WebApiService } from './web-api.service'
import * as jwt_decode from "jwt-decode";

const apiUrl = BasicUrlLink.basicLink + '/api/Auth'

const httpLink = {
  login: apiUrl + '/login',
}

const roleNames = {
  adminRoleName: "ADMIN",
  userRoleName: "USER"
}

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(private webApiService: WebApiService) {}

  login(requestBody: {login:string, password:string}) {
    return this.webApiService.post(httpLink.login, requestBody);
  }

  isUserLogged() {
    return localStorage.getItem("token") !== null;
  }

  decodeJWTToken(token: string) {
    return jwt_decode.jwtDecode(token);
  }

  getLoggedUserJWTPayload() {
    if (localStorage.getItem("token") !== null) {
      let payloadAsJSON = JSON.parse(window.atob((localStorage.getItem("token") as string).split('.')[1]))
      return payloadAsJSON;
    }
    return null;
  }

  isLoggedUserHasRole(roleName: string) {
    if (this.getLoggedUserJWTPayload() === null)
      return false;
    else
      return this.getLoggedUserJWTPayload().roles.includes(roleName);
  }
}
