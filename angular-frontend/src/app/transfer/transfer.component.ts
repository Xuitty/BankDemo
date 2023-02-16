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
    public router: Router
  ) {}

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  message?: string = '';
  login: boolean = false;
  action?: string = 'transfer';
  ucookie?: string;
  intervalCheck?: any;
  @Input('allActivedAccount') allActivedAccount!: Account[];
  @Input('transferAccount') transferAccount!: Account;
  @Input('currentUserUid') currentUserUid!: number;

  scheduleSwitchStatus: boolean = false;
  scheduleSwitchChecked: string = '';

  transfer: Transfer = new Transfer();
  transferingTid?: number;

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
    this.intervalCheck = setInterval(() => {
      //auto logout function
      this.checkCookieExpired().then(
        (res) => {
          console.log(res);

          if (!res) {
            clearInterval(this.intervalCheck);
            this.doCookieExpired();
          }
        },
        (reject) => {
          clearInterval(this.intervalCheck);
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
        result = res;
        console.log(res);
        this.renewTime(new User(undefined, undefined, this.currentUserUid)); //manual update(onClick)
        if (!res) {
          clearInterval(this.intervalCheck);
          this.doCookieExpired();
          return;
        }
      },
      (reject) => {
        clearInterval(this.intervalCheck);
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );
    if (!result) {
      return;
    }
    let check: boolean = this.formCheck();
    if (!check) {
      return;
    }
    // let transfer: Transfer = new Transfer();
    this.transfer.senderAccount = this.transferAccount.aaccount!;
    this.transfer.receiverBankCode = this.receiverBankCode?.nativeElement.value;
    this.transfer.receiverAccount = this.receiverAccount?.nativeElement.value;
    if (this.transfer.receiverAccount?.length! < 12) {
      // console.log(this.transfer.receiverAccount?.length!);

      this.transfer.receiverAccount = this.transfer.receiverAccount?.padStart(
        12,
        '0'
      );
    }
    this.transfer.schedule = this.scheduleSwitchStatus;
    if (this.transfer.schedule) {
      this.transfer.scheduleTime = String(
        this.dateTime?.nativeElement.value
      ).replace('T', ' ');
    }
    this.transfer.amountString = this.amountString?.nativeElement.value;
    this.transfer.currencyType = this.currencyType?.nativeElement.value;

    await lastValueFrom(
      this.http.post<Status>(this.server + 'doTransfer', this.transfer)
    ).then(
      async (res) => {
        console.log(res);

        if (res.statuss == 3) {
          if (res.message == 'emailAddressError') {
            let counter: number = 5;

            await new Promise<void>((res) => {
              let timer = setInterval(() => {
                if (counter <= 0) {
                  clearInterval(timer);
                  res();
                }
                this.message =
                  '使用者電子郵件有誤，此次交易作廢<br>請至個人專區檢查或聯繫客服 0800-806-449<br>' +
                  counter +
                  '秒後將重新導向至主頁';
                counter--;
              }, 1000);
            });
          }
          if (res.message == 'accountNotExist') {
            let counter: number = 5;

            await new Promise<void>((res) => {
              let timer = setInterval(() => {
                if (counter <= 0) {
                  clearInterval(timer);
                  res();
                }
                this.message =
                  '您的帳戶號碼有誤，此次交易作廢，請聯繫客服 0800-806-449<br>' +
                  counter +
                  '秒後將重新導向至主頁';
                counter--;
              }, 1000);
            });
          }
          this.router.navigate(['login']);
        } else if (res.statuss == 1) {
          this.transferingTid = Number.parseInt(res.message!);
          this.action = 'verify';
        } else {
          let counter: number = 5;

          await new Promise<void>((res) => {
            let timer = setInterval(() => {
              if (counter <= 0) {
                clearInterval(timer);
                res();
              }
              this.message =
                '伺服器錯誤，此次交易作廢，請聯繫客服 0800-806-449<br>' +
                counter +
                '秒後將重新導向至主頁';
              counter--;
            }, 1000);
          });
          this.router.navigate(['login']);
        }
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );
  }
  @ViewChild('tverify') tverify?: ElementRef;
  async doVerify() {
    let result1: boolean = false;
    await this.checkCookieExpired().then(
      (res) => {
        result1 = res;
        console.log(res);
        this.renewTime(new User(undefined, undefined, this.currentUserUid)); //manual update(onClick)
        if (!res) {
          clearInterval(this.intervalCheck);
          this.doCookieExpired();
          return;
        }
      },
      (reject) => {
        clearInterval(this.intervalCheck);
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );
    if (!result1) {
      return;
    }

    let verify = this.tverify?.nativeElement.value;
    let transfer: Transfer = new Transfer();
    let result: Status = new Status();
    transfer.tid = this.transferingTid;
    transfer.verify = verify;
    await lastValueFrom(
      this.http.post<Status>(this.server + 'doTransferVerify', transfer)
    ).then(
      (res) => {
        console.log(res);

        result = res;
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
      }
    );

    if (this.transfer.schedule) {
      if (result.statuss == 0) {
        this.action == 'scheduledTransferResultSuccess';
        this.message =
          '將在您預定的時間轉帳，交易結果將寄出電子郵件通知，請留意收件匣';
      } else if (result.statuss == 3) {
        if (result.errorCode == 6) {
          this.action == 'scheduledTransferResultFailed';
          let counter: number = 6;
          let timer: any = setInterval(() => {
            counter--;
            this.message = '交易不存在，' + counter + '秒後將導向首頁';
            if (counter < 1) {
              clearInterval(timer);
              this.router.navigate(['login']);
            }
          }, 1000);
        } else {
          this.action == 'scheduledTransferResultFailed';
          this.message = '未知的錯誤';
        }
      }
    } else {
      if (result.statuss == 1) {
        this.action == 'transferResultSuccess';
        this.message =
          '轉出帳號:' +
          this.transfer.senderAccount +
          '<br>' +
          '轉入帳號:(' +
          this.transfer.receiverBankCode +
          ')-' +
          this.transfer.receiverAccount +
          '<br>' +
          '金額' +
          (this.transfer.currencyType == 1 ? '$NTD' : '$USD') +
          this.transfer.amountString +
          '元<br>餘額:' +
          result.message;
      }
    }
    console.log(this.action);
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

  formCheck(): boolean {
    if (
      this.receiverAccount?.nativeElement.value == '' ||
      this.amountString?.nativeElement.value == ''
    ) {
      this.message = '請填寫轉帳資訊';
      return false;
    }
    if (this.currencyType?.nativeElement.value == 1) {
      let amountString: string = this.amountString?.nativeElement.value;
      if (amountString.includes('.')) {
        this.message = '台幣交易不可含有小數';
        return false;
      }
    }
    let dateTime: string = this.dateTime?.nativeElement.value;
    if (this.scheduleSwitchStatus && dateTime.length < 1) {
      this.message = '請選擇預約日期';
      return false;
    }

    if (
      String(this.receiverAccount?.nativeElement.value).search(/[^0-9]/) != -1
    ) {
      this.message = '轉入帳號格式錯誤';
      return false;
    }
    if (
      String(this.amountString?.nativeElement.value).search(/[^0-9.]/) != -1 ||
      String(this.amountString?.nativeElement.value).length > 38
    ) {
      this.message = '轉帳金額格式錯誤';
      return false;
    }
    return true;
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
