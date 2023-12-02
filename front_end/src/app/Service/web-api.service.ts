import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
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
        catchError(this.handleError)
      );
  }

  post(url: string, requestBody: any): Observable<any> {
    return this.httpClient.post(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError(this.handleError)
      );
  }

  patch(url: string, requestBody: any): Observable<any> {
    return this.httpClient.patch(url, requestBody, httpOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError(this.handleError)
      );
  }

  delete(url: string, requestBody: any): Observable<any> {
    httpDeleteOptions.body = requestBody;
    return this.httpClient.delete(url, httpDeleteOptions)
      .pipe(
        map((response: any) => this.ReturnResponseData(response)),
        catchError(this.handleError)
      );
  }

  private ReturnResponseData(response: any) {
    return response;
  }

  private handleError(error: any) {
    return throwError(error);
  }
}
