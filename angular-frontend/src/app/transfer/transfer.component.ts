import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { lastValueFrom } from 'rxjs';
import SERVER from '../../assets/json/config.json';
import { Account } from '../entity/account';
import { User } from '../entity/user';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css'],
})
export class TransferComponent implements OnInit {
  constructor(
    private cookie: CookieService,
    private http: HttpClient,
    private router: Router
  ) {}

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  message?: string = '';
  login: boolean = false;
  action?: string = '';
  ucookie?: string;
  @Input('allActivedAccount') allActivedAccount?: Account[];
  @Input('transferAccount') transferAccount!: Account;
  @Input('currentUserUid') currentUserUid?: number;

  scheduleSwitchStatus: boolean = false;
  scheduleSwitchChecked: string = '';

  async ngOnInit() {
    this.message = '';

    console.log(this.allActivedAccount);
    console.log(this.transferAccount);
    console.log(this.currentUserUid);

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
    let user: User = new User();
    user.uid = this.currentUserUid;
    this.renewTime(user);
    this.ucookie = this.cookie.get('username');
    let intervalCheck = setInterval(async () => {
      //auto logout function
      await this.checkCookieExpired().then(
        (res) => {
          console.log(res);

          if (!res) {
            clearInterval(intervalCheck);
            this.doLogout();
          }
        },
        (reject) => {
          clearInterval(intervalCheck);
          console.log(reject);
          this.router.navigate(['500']);
        }
      );
    }, 30000);
  }

  @ViewChild('dateTime') dateTime?: ElementRef;
  scheduleSwitch() {
    console.log(typeof this.dateTime?.nativeElement.value);
    console.log(this.dateTime?.nativeElement.value);
    console.log(Date.parse(this.dateTime?.nativeElement.value));
    this.scheduleSwitchStatus =
      this.scheduleSwitchStatus === false ? true : false;
    this.scheduleSwitchChecked =
      this.scheduleSwitchStatus === false ? '' : 'checked';
  }

  @ViewChild('senderAccount') senderAccount?: ElementRef;
  currentBalance?: string;
  selectAccount() {
    let acc: Account = this.senderAccount?.nativeElement.value;
    this.transferAccount = acc;
    this.currentBalance = acc.abalance;
    console.log(this.senderAccount?.nativeElement);
    console.log(acc.abalance);
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
    return lastValueFrom<User>(
      this.http.post<User>(this.server + 'renewCookieTime', user)
    );
  }

  checkCookieExpired() {
    return lastValueFrom(
      this.http.get<boolean>(
        this.server + 'checkCookieExpired?cookie=' + this.cookie.get('username')
      )
    );
  }

  doLogout() {
    this.cookie.deleteAll();
    this.router.navigate(['']);
  }
}
