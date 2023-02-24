import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { SERVER_PROPERTY } from 'SERVER';

@Injectable({
  providedIn: 'root',
})
export class TimerService {
  constructor(private http: HttpClient, private cookie: CookieService) {}

  deleteCookie() {
    // let server: string = JSON.parse(JSON.stringify(SERVER)).url;
    let server: string = SERVER_PROPERTY.SERVER_URL;
    // this.http.post{server+'cookieDeleteService'}
  }
}
