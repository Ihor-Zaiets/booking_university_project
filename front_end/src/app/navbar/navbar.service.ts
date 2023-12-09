import { BasicUrlLink } from '../BasicUrlLink'
import { Injectable } from '@angular/core'
import { WebApiService } from '../Service/web-api.service'

const apiAuthUrl = BasicUrlLink.basicLink + '/api/Auth'

const httpLink = {
  loggedUser: apiAuthUrl + '/loggedUser',
}

@Injectable({
  providedIn: 'root',
})

export class NavbarService {

  constructor(private webApiService: WebApiService) {}

  getLoggerUser() {
    return this.webApiService.get(httpLink.loggedUser);
  }
}
