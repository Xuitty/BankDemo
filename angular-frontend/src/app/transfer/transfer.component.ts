import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { lastValueFrom } from 'rxjs';
import SERVER from '../../assets/json/config.json';
import { Account } from '../entity/account';
import { Status } from '../entity/status';
import { Transfer } from '../entity/transfer';
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
  action?: string = 'transfer';
  ucookie?: string;
  @Input('allActivedAccount') allActivedAccount!: Account[];
  @Input('transferAccount') transferAccount!: Account;
  @Input('currentUserUid') currentUserUid!: number;

  scheduleSwitchStatus: boolean = false;
  scheduleSwitchChecked: string = '';

  async ngOnInit() {
    this.message = '';

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
    this.currentBalance = this.transferAccount.abalance;
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

  @ViewChild('accountSelector') accountSelector?: ElementRef;
  currentBalance?: string;
  selectAccount() {
    this.transferAccount = this.allActivedAccount?.find(
      (item, index, array) => {
        return item.aaccount == this.accountSelector?.nativeElement.value;
      }
    )!;
    this.currentBalance = this.transferAccount.abalance;
    console.log(this.accountSelector?.nativeElement);
    console.log(this.transferAccount.abalance);
  }

  @ViewChild('receiverBankCode') receiverBankCode?: ElementRef;
  @ViewChild('receiverAccount') receiverAccount?: ElementRef;
  @ViewChild('currencyType') currencyType?: ElementRef;
  @ViewChild('amountString') amountString?: ElementRef;
  async doTransfer() {
    let result: boolean = false;
    await this.checkCookieExpired().then(
      (res) => {
        if (res != true) {
          result = false;
          return;
        }
        result = true;
        this.renewTime(new User(undefined, undefined, this.currentUserUid));
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
      }
    );
    if (result == false) {
      return;
    }
    if (this.currencyType?.nativeElement.value == 1) {
      let amountString: string = this.amountString?.nativeElement.value;
      if (amountString.includes('.')) {
        this.message = '台幣交易不可含有小數';
        return;
      }
    }
    let transfer: Transfer = new Transfer();
    transfer.sender_account = this.transferAccount.aaccount!;
    transfer.receiver_bank_code = this.receiverBankCode?.nativeElement.value;
    transfer.receiver_account = this.receiverAccount?.nativeElement.value;
    transfer.schedule = this.scheduleSwitchStatus;
    if (transfer.schedule) {
      transfer.schedule_time = Date.parse(this.dateTime?.nativeElement.value);
    }
    transfer.amount_string = this.amountString?.nativeElement.value;
    transfer.currency_type = this.currencyType?.nativeElement.value;
    await lastValueFrom(
      this.http.post<Status>(this.server + 'doTransfer', transfer)
    ).then((res) => {
      if (res.statuss == 0 || res.statuss == 1) {
        this.action = 'verify';
      }
    });
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
