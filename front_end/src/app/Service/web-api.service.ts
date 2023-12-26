import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http'
import { catchError, map, Observable, throwError } from 'rxjs'
import { ToastrService } from 'ngx-toastr'

const token = localStorage.getItem("token");

let headers: HttpHeaders = new HttpHeaders({
  'Content-Type':  'application/json'
})

if (token !== null) {
  headers = headers.set('Authorization', 'Bearer ' + token);
}

const httpGetOptions = {
  headers: headers.set('Cache-Control', 'no-cache').set('Pragma', 'no-cache'),
  observe: "response" as 'body'
};

const httpOptions = {
  headers: headers,
  observe: "response" as 'body'
};

const httpDeleteOptions = {
  headers: headers,
  observe: "response" as 'body',
  body: null,
}

@Injectable({
  providedIn: 'root'
})
export class WebApiService {

  constructor(private httpClient: HttpClient, private toastr: ToastrService) { }

  get(url: string): Observable<any> {
    console.log("webApiService, get, url: ", url, " httpGetOptions: ", httpGetOptions)
    return this.httpClient.get(url, httpGetOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  post(url: string, requestBody: any): Observable<any> {
    console.log("webApiService, post, url: ", url, " requestBody: ", requestBody, " httpOptions: ", httpOptions)
    return this.httpClient.post(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  patch(url: string, requestBody: any): Observable<any> {
    console.log("webApiService, patch, url: ", url, " requestBody: ", requestBody, " httpOptions: ", httpOptions)
    return this.httpClient.patch(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  delete(url: string, requestBody: any): Observable<any> {
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
