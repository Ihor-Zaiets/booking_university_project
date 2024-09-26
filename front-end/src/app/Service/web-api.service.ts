import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http'
import { catchError, map, Observable, throwError } from 'rxjs'
import { ToastrService } from 'ngx-toastr'
import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class WebApiService {

  constructor(private httpClient: HttpClient, private toastr: ToastrService) { }

  createHeaders(): HttpHeaders {
    const token = localStorage.getItem("token");
    const currentTime: number = Math.floor(Date.now() / 1000);
    let headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    if (token !== null) {
      if (jwt_decode.jwtDecode(token).exp! > currentTime) {
        headers = headers.set('Authorization', 'Bearer ' + token);
      } else {
        localStorage.removeItem("token");
      }
    }
    return headers;
  }

  get(url: string): Observable<any> {
    const httpGetOptions = {
      headers: this.createHeaders().set('Cache-Control', 'no-cache').set('Pragma', 'no-cache'),
      observe: "response" as 'body'
    };
    console.log("webApiService, get, url: ", url, " httpGetOptions: ", httpGetOptions)
    return this.httpClient.get(url, httpGetOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  post(url: string, requestBody: any): Observable<any> {
    const httpOptions = {
      headers: this.createHeaders(),
      observe: "response" as 'body'
    };
    console.log("webApiService, post, url: ", url, " requestBody: ", requestBody, " httpOptions: ", httpOptions)
    return this.httpClient.post(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  patch(url: string, requestBody: any): Observable<any> {
    const httpOptions = {
      headers: this.createHeaders(),
      observe: "response" as 'body'
    };
    console.log("webApiService, patch, url: ", url, " requestBody: ", requestBody, " httpOptions: ", httpOptions)
    return this.httpClient.patch(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  delete(url: string, requestBody: any): Observable<any> {
    const httpDeleteOptions = {
      headers: this.createHeaders(),
      observe: "response" as 'body',
      body: null,
    }
    httpDeleteOptions.body = requestBody;
    console.log("webApiService, delete, url: ", url, " requestBody: ", httpDeleteOptions)
    return this.httpClient.delete(url, httpDeleteOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  private ReturnResponseData(response: any) {
    return response;
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status >= 400 && error.status <= 499)
      this.toastr.error(error.error.message);
    else
      this.toastr.error('Nieoczekiwany błąd. Skontaktuj się z administratorem');
    return throwError(error);
  }
}
