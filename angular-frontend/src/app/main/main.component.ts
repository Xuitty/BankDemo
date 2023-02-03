import { HttpClient } from '@angular/common/http';
import {
  Component,
  HostListener,
  OnInit,
  OnDestroy,
  ViewChild,
  ElementRef,
} from '@angular/core';
import { Router } from '@angular/router';
import Decimal from 'decimal.js';
import { CookieService } from 'ngx-cookie-service';
import { lastValueFrom } from 'rxjs/internal/lastValueFrom';
import SERVER from '../../assets/json/config.json';
import { Account } from '../entity/account';
import { Info } from '../entity/Info';
import { Status } from '../entity/status';
import { User } from '../entity/user';
import { TimerService } from '../services/timer/timer.service';
@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  constructor(
    private http: HttpClient,
    private cookie: CookieService,
    private timer: TimerService,
    private router: Router
  ) {}

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  login: boolean = true;
  action: string = '';
  message: string = '';
  uname: string = '';
  uid: number = -1;

  accountCount?: number;
  creditCardCount?: number;
  debitCardCount?: number;
  totalMoney?: string;

  async ngOnInit() {
    this.message = '';
    // console.log(this.server);

    // if (!this.cookie.check('username')) {
    //   this.message = '請登入金發財，共享榮華富貴';
    //   let counter = 6;
    //   await new Promise((res) => {
    //     let timer = setInterval(() => {
    //       counter--;
    //       this.message =
    //         '請登入金發財，共享榮華富貴<br>將於' +
    //         counter +
    //         '秒後導向至登入頁面';
    //       if (counter == 0) {
    //         clearInterval(timer);
    //         res;
    //       }
    //     }, 1000);
    //   });
    //   console.log('done');

    //   return;
    // }

    if (!this.cookie.check('username')) {
      // this.message = '請登入金發財，共享榮華富貴';
      let counter = 6;
      await new Promise<void>((res) => {
        let timer = setInterval(() => {
          counter--;
          this.message =
            '請登入金發財，共享榮華富貴<br><br>將於' +
            counter +
            '秒後導向至登入頁面';
          if (counter == 0) {
            clearInterval(timer);
            res();
          }
        }, 1000);
      });
      this.router.navigate(['login']);

      return;
    }
    let ucookie = this.cookie.get('username');
    let user: User = new User();
    user.ucookie = ucookie;
    let result: Info = new Info();
    await lastValueFrom(
      this.http.post<Info>(this.server + 'mainGetInfo', user)
    ).then((res) => {
      result = res;
      // console.log('res');
      // console.log(res);
    });
    // console.log(result);

    if (result == null) {
      this.cookie.deleteAll();
      let counter = 6;
      await new Promise<void>((res) => {
        let timer = setInterval(() => {
          counter--;
          this.message =
            '請登入金發財，共享榮華富貴<br><br>將於' +
            counter +
            '秒後導向至登入頁面';
          if (counter == 0) {
            clearInterval(timer);
            res();
          }
        }, 1000);
      });
      this.router.navigate(['login']);

      return;
    }
    user = new User();
    user.uid = result.uid;
    this.renewTime(user);
    this.login = true;
    this.action = 'main';
    this.uid = result.uid;
    this.uname = result.uname;
    this.accountCount = result.account;
    this.creditCardCount = result.creditCard;
    this.debitCardCount = result.debitCard;
    this.totalMoney = result.totalMoney;
    // console.log(result.totalMoney);

    // this.timer.deleteCookie();
  }

  goCreateAccount() {
    this.action = 'createAccount';
  }
  goCreateCreditCard() {
    this.action = 'createCreditCard';
  }

  @ViewChild('accountType') accountType?: ElementRef;
  @ViewChild('accountCurrencyType') accountCurrencyType?: ElementRef;
  async doCreateAccount() {
    this.message = '';
    if (
      this.accountType?.nativeElement.value == -1 ||
      this.accountCurrencyType?.nativeElement.value == -1
    ) {
      this.message = '請選取選項';
      return;
    }
    if (
      this.accountType?.nativeElement.value == 1 ||
      this.accountCurrencyType?.nativeElement.value == 1
    ) {
      let account: Account = new Account();
      account.atype = 1;
      account.uid = this.uid;
      await lastValueFrom(
        this.http.post<Status>(this.server + 'createAccount', account)
      ).then((res) => {
        console.log(res);
      });
    }
  }
  async renewTime(user: User) {
    if (user.uid == undefined || user.uid == null) {
      return;
    }
    await lastValueFrom<User>(
      this.http.post<User>(this.server + 'renewCookieTime', user)
    ).then((res) => {
      user = res;
    });
    let old_cookie = this.cookie.get('username');
    console.log();

    this.cookie.set('username', old_cookie, new Date(user.lasttime!));
  }

  // @HostListener('document:visibilitychange')
  // async unloadHandler() {
  //   // this.http.get(this.server + 'cookieDeleteService').subscribe();
  //   debugger;
  //   await lastValueFrom(this.http.get(this.server + 'cookieDeleteService'));
  // }
  // async ngOnDestroy() {
  //   await lastValueFrom(this.http.get(this.server + 'cookieDeleteService'));
  // }
  ////
}
