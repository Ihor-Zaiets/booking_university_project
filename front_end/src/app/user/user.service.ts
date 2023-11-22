import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BasicUrlLink } from '../BasicUrlLink'

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getData() {
    return this.http.get(BasicUrlLink.basicLink + '/api/User/searchAll');
  }
}
