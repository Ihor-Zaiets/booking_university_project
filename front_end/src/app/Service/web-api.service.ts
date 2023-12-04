import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http'
import { catchError, map, Observable, throwError } from 'rxjs'
import { ToastrService } from 'ngx-toastr'

const httpGetOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Cache-Control' : 'no-cache',
    'Pragma' : 'no-cache'
  }),
  observe: "response" as 'body'
};

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  }),
  observe: "response" as 'body'
};

const httpDeleteOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
  observe: "response" as 'body',
  body: null,
}

@Injectable({
  providedIn: 'root'
})
export class WebApiService {

  constructor(private httpClient: HttpClient, private toastr: ToastrService) { }

  get(url: string): Observable<any> {
    return this.httpClient.get(url, httpGetOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  post(url: string, requestBody: any): Observable<any> {
    return this.httpClient.post(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  patch(url: string, requestBody: any): Observable<any> {
    return this.httpClient.patch(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError((error) => this.handleError(error))
      );
  }

  delete(url: string, requestBody: any): Observable<any> {
    httpDeleteOptions.body = requestBody;
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
