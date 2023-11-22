import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Injectable } from '@angular/core';
import { BasicUrlLink } from '../BasicUrlLink'
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getData() {
    return this.http.get(BasicUrlLink.basicLink + '/api/User/searchAll');
  }

  postData(requestBody: any): Observable<any> {
    const url = BasicUrlLink.basicLink + `/api/User/createAll`; // replace with your specific endpoint
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });

    return this.http.post<any>(url, requestBody, { headers });
  }
}
