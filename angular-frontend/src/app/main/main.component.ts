import { HttpClient } from '@angular/common/http';
import { Component, HostListener, OnInit, OnDestroy } from '@angular/core';
import Decimal from 'decimal.js';
import { CookieService } from 'ngx-cookie-service';
import { lastValueFrom } from 'rxjs/internal/lastValueFrom';
import SERVER from '../../assets/json/config.json';
import { Info } from '../entity/Info';
import { User } from '../entity/user';
import { TimerService } from '../services/timer/timer.service';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit, OnDestroy {
  constructor(
    private http: HttpClient,
    private cookie: CookieService,
    private timer: TimerService
  ) {}

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  login: boolean = true;
  action: string = '';
  message: string = '';
  uname: string = '';

  accountCount?: number;
  creditCardCount?: number;
  debitCardCount?: number;
  totalMoney?: string;

  async ngOnInit() {
    this.message = '';
    // console.log(this.server);

    if (!this.cookie.check('username')) {
      this.message = '請登入金發財，共享榮華富貴';
      return;
    }
    let ucookie = this.cookie.get('username');
    let user: User = new User();
    user.ucookie = ucookie;
    let result: Info = new Info();
    await lastValueFrom(
      this.http.post<Info>(this.server + 'mainGetInfo', user)
    ).then(
      (res) => {
        result = res;
        console.log('res');
        console.log(res);
      },
      (reject) => {
        reject = null;
        console.log(reject);
        console.log('reject');
      }
    );
    if (result == null) {
      this.message = '請登入金發財，共享榮華富貴';
      return;
    }

    this.login = true;
    this.action = 'main';
    this.uname = result.uname;
    this.accountCount = result.account;
    this.creditCardCount = result.creditCard;
    this.debitCardCount = result.debitCard;
    Decimal.set({ precision: 50 });
    this.totalMoney = result.totalMoney.toFixed(4);
    console.log(result.totalMoney);

    // this.timer.deleteCookie();
  }

  // @HostListener('document:visibilitychange')
  // async unloadHandler() {
  //   // this.http.get(this.server + 'cookieDeleteService').subscribe();
  //   debugger;
  //   await lastValueFrom(this.http.get(this.server + 'cookieDeleteService'));
  // }
  async ngOnDestroy() {
    await lastValueFrom(this.http.get(this.server + 'cookieDeleteService'));
  }
  ////
}
