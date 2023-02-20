import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { lastValueFrom } from 'rxjs';
import { Account } from 'src/app/entity/account';
import { User } from 'src/app/entity/user';
import SERVER from '../../../assets/json/config.json';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
})
export class HistoryComponent implements OnInit {
  constructor(
    private cookie: CookieService,
    private http: HttpClient,
    public router: Router
  ) {}

  message: string = '';

  intervalCheck: any;

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  @Input('historyAccount')
  historyAccount?: Account;
  @Input('currentUserUid')
  currentUserUid?: number;
  @Input('allActivedAccount')
  allActivedAccount?: Account[];

  async ngOnInit() {
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
    let result: boolean | object = await this.checkCookieExpired();
    if (typeof result === typeof Boolean(true)) {
      if (!result) {
        this.cookie.deleteAll();
        this.doCookieExpired();
        return;
      }
    } else {
      this.router.navigate(['500']);
      return;
    }

    this.intervalCheck = setInterval(async () => {
      //auto logout function
      let result: boolean | object = await this.checkCookieExpired();
      if (typeof result === typeof Boolean(true)) {
        if (!result) {
          this.cookie.deleteAll();
          this.doCookieExpired();
          return;
        }
      } else {
        this.router.navigate(['500']);
        return;
      }
    }, 30000);
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

    this.cookie.set('username', old_cookie, new Date(user.lasttime!));
    return lastValueFrom<User>(
      this.http.post<User>(this.server + 'renewCookieTime', user)
    );
  }

  async checkCookieExpiredRenew() {
    return await lastValueFrom(
      this.http.get<boolean | object>(
        this.server + 'checkCookieExpired?cookie=' + this.cookie.get('username')
      )
    ).then(
      (res) => {
        console.log(res);
        if (res) {
          this.renewTime(new User(undefined, undefined, this.currentUserUid));
        } else {
          clearInterval(this.intervalCheck);
        }
        return Boolean(res);
      },
      (reject) => {
        console.log(reject);
        // this.router.navigate(['500']);
        clearInterval(this.intervalCheck);
        return Object(reject);
      }
    );
  }

  async checkCookieExpired() {
    return await lastValueFrom(
      this.http.get<boolean | object>(
        this.server + 'checkCookieExpired?cookie=' + this.cookie.get('username')
      )
    ).then(
      (res) => {
        console.log(res);
        if (!res) {
          clearInterval(this.intervalCheck);
        }
        return Boolean(res);
      },
      (reject) => {
        console.log(reject);
        clearInterval(this.intervalCheck);
        // this.router.navigate(['500']);
        return Object(reject);
      }
    );
  }

  doLogout() {
    this.cookie.deleteAll();
    this.router.navigate(['']);
  }

  doCookieExpired() {
    this.cookie.deleteAll();
    this.router.navigate(['cookieExpired']);
  }
}
