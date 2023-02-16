import { HttpClient } from '@angular/common/http';
import {
  Component,
  HostListener,
  OnInit,
  OnDestroy,
  AfterViewChecked,
  ViewChild,
  ElementRef,
  AfterViewInit,
  TemplateRef,
} from '@angular/core';
import { Router } from '@angular/router';
import {
  Chart,
  ChartConfiguration,
  ChartData,
  ChartDataset,
  ChartOptions,
  ChartType,
  ChartTypeRegistry,
  TooltipItem,
} from 'chart.js';
import { PointElement, Tooltip } from 'chart.js/dist';
import Decimal from 'decimal.js';
import { CookieService } from 'ngx-cookie-service';
import { lastValueFrom } from 'rxjs/internal/lastValueFrom';
import SERVER from '../../assets/json/config.json';
import { Account } from '../entity/account';
import { Card } from '../entity/card';
import { Info } from '../entity/Info';
import { Status } from '../entity/status';
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
    public router: Router
  ) {}
  ngOnDestroy(): void {
    clearInterval(this.intervalCheck);
  }
  intervalCheck: any;

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  login: boolean = false;
  action: string = '';
  message: string = '';
  uname: string = '';
  uid: number = -1;

  // lasttime: number = -1;  **********counterUtil**********

  allAccount?: Account[];
  allActivedAccount?: Account[];
  allAccountCount?: number;
  allActivedAccountCount?: number;
  allcreditCard?: Card[];
  allActivedCreditCard?: Card[];
  allcreditCardCount?: number;
  allActivedCreditCardCount?: number;
  allDebitCard?: Card[];
  allActivedDebitCard?: Card[];
  allDebitCardCount?: number;
  allActivedDebitCardCount?: number;
  totalMoney?: string;

  currentAid?: number;

  @ViewChild('chart') chart?: Chart;

  accountChartOptions: ChartConfiguration['options'] = {};
  accountChartType: ChartType = 'doughnut';
  accountChartLegend = false;

  accountChartLabels: string[] = [];
  accountChartData: any = [];

  notempty: any;
  empty: any;

  transferAccount?: Account;
  currentUserUid?: number;

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
    ).then(
      (res) => {
        result = res;
        console.log(res);

        // console.log('res');
        // console.log(res);
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );
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
    this.allAccount = result.allAccount;
    this.allActivedAccount = result.allActivedAccount;
    this.allcreditCard = result.allCreditCard;
    this.allActivedCreditCard = result.allActivedCreditCard;
    this.allDebitCard = result.allDebitCard;
    this.allActivedDebitCard = result.allActivedDebitCard;

    this.allAccountCount = result.allAccount.length;
    this.allActivedAccountCount = result.allActivedAccount.length;
    this.allcreditCardCount = result.allCreditCard.length;
    this.allActivedCreditCardCount = result.allActivedCreditCard.length;
    this.allDebitCardCount = result.allDebitCard.length;
    this.allActivedDebitCardCount = result.allActivedDebitCard.length;
    this.totalMoney = result.totalMoney;

    let accountNicknames: string[] = [];

    let accountBalances: Decimal[] = [];
    this.allAccount.forEach((acc) => {
      if (!new Decimal(acc.abalance!).equals(new Decimal(0))) {
        accountBalances.push(new Decimal(acc.abalance!));
        if (acc.anickname == null) {
          accountNicknames.push('(未命名)');
        } else {
          accountNicknames.push(acc.anickname);
        }
      }
      // console.log(acc.anickname + ' : ' + acc.abalance);
      // console.log(accountNicknames + ' : ' + accountBalances);
    });
    // console.log(accountBalances.toString());
    this.accountChartLabels = accountNicknames;
    this.accountChartData = [
      {
        data: accountBalances,
        label: '',
        backgroundColor: [
          'rgb(255, 99, 132)',
          'rgb(54, 162, 235)',
          'rgb(255, 205, 86)',
          'rgb(245, 144, 206)',
          'rgb(188, 245, 127)',
          'rgb(171, 235, 134)',
          'rgb(147, 114, 247)',
          'rgb(197, 199, 197)',
          'rgb(37, 250, 250)',
        ],
      },
    ];
    this.accountChartOptions = {
      // events: ['click', 'mouseleave'],
      responsive: true,
      // hover: {
      //   mode: 'nearest',
      //   intersect: true,
      // },
      // onClick: (event, element) => {
      //   console.log(element[0].element.getProps(['$context']));
      //   console.log('clicked');
      // },
      // onHover: (event, element, chart) => {
      //   console.log(chart.data.datasets[0].data[0]?.toString());
      //   chart.tooltip?.setActiveElements([element[0]], {
      //     x: 0,
      //     y: 0,
      //   });
      // },
      plugins: {
        tooltip: {
          enabled: true,
          intersect: true,
          mode: 'nearest',
          callbacks: {
            label: (tooltipItems: TooltipItem<ChartType>) => {
              return tooltipItems.formattedValue + ' 元';
            },
          },
        },
      },
    };
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

    // if (result.lasttime == -1) {  **********counterUtil**********
    //   await this.renewTime(user).then(
    //     (res) => {
    //       this.lasttime = res!.lasttime!;
    //     },
    //     (reject) => {
    //       console.log(reject);
    //       this.router.navigate(['500']);
    //     }
    //   );
    // } else {
    //   this.lasttime = result.lasttime;
    // }
    // this.message = this.lasttime.toString();

    // console.log(result.totalMoney);

    // this.timer.deleteCookie();
  }

  async goCreateAccount() {
    let result: boolean = false;
    await this.checkCookieExpired().then(
      (res) => {
        result = res;
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );

    if (result) {
      let user: User = new User();
      user.uid = this.uid;
      this.renewTime(user);
      this.action = 'createAccount';
    } else {
      this.router.navigate(['cookieExpired']);
    }
  }
  async goCreateCreditCard() {
    let result: boolean = false;
    await this.checkCookieExpired().then(
      (res) => {
        result = res;
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );
    if (result) {
      let user: User = new User();
      user.uid = this.uid;
      this.renewTime(user);
      this.action = 'createCreditCard';
    } else {
      this.router.navigate(['cookieExpired']);
    }
  }

  @ViewChild('accountType') accountType?: ElementRef;
  @ViewChild('accountCurrencyType') accountCurrencyType?: ElementRef;
  async doCreateAccount() {
    let result: boolean = false;
    await this.checkCookieExpired().then(
      (res) => {
        result = res;
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );

    if (result) {
      this.action = 'createAccount';

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

        let result: Status = await lastValueFrom(
          this.http.post<Status>(this.server + 'createAccount', account)
        ).then((res) => {
          console.log(res);

          return res;
        });
        if (result.statuss == 1 && result.message != null) {
          this.renewTime(new User(undefined, undefined, this.uid));
          this.currentAid = Number.parseInt(result.message);
          this.action = 'verifyAccount';
        } else {
          this.router.navigate(['500']);
        }
      }
    } else {
      this.router.navigate(['cookieExpired']);
    }
  }
  @ViewChild('averify') averify?: ElementRef;
  async doVerifyAccount() {
    let result: boolean = false;
    await this.checkCookieExpired().then(
      (res) => {
        result = res;
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );
    if (result) {
      let averify: string = this.averify?.nativeElement.value;
      if (averify == '' || averify.length != 6) {
        this.message = '請填入驗證碼';
        return;
      }
      let account: Account = new Account();
      account.aid = this.currentAid;
      account.averify = averify;
      console.log(account);

      let r: Status = await lastValueFrom<Status>(
        this.http.post<Status>(this.server + 'verifyAccount', account)
      ).then(
        (res) => {
          return res;
        },
        (reject) => {
          console.log(reject);
          // this.router.navigate(['500']);
          return new Status(4, undefined, 'Server error');
        }
      );
      console.log(r);

      if (r.statuss == 0) {
        this.renewTime(new User(undefined, undefined, this.uid));
        let counter: number = 6;
        await new Promise<void>((res) => {
          let timer = setInterval(() => {
            counter--;
            this.message =
              '信箱驗證完成，請等待我們審核通過，謝謝您的耐心等候<br>將於' +
              counter +
              '秒後回到首頁';
            if (counter == 0) {
              clearInterval(timer);
              res();
            }
          }, 1000);
        });
        console.log(123);

        location.href = './main';
      } else if (
        r.statuss == 3 &&
        (r.message == 'emailAddressError' || r.message == 'emailError')
      ) {
        this.message = '信箱無法收信，請聯絡客服修改';
      } else {
        this.message = '未知的錯誤';
      }
    } else {
      this.router.navigate(['cookieExpired']);
    }
  }

  async goTransfer(acc: Account) {
    let result: boolean = false;
    await this.checkCookieExpired().then(
      (res) => {
        result = res;
      },
      (reject) => {
        console.log(reject);
        this.router.navigate(['500']);
        return;
      }
    );

    if (result) {
      this.transferAccount = acc;
      this.currentUserUid = this.uid;
      let user: User = new User();
      user.uid = this.uid;
      this.renewTime(user);
      clearInterval(this.intervalCheck);
      // this.router.navigate(['main/transfer']);
      this.action = 'transfer';
    } else {
      clearInterval(this.intervalCheck);
      this.router.navigate(['cookieExpired']);
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

  doCookieExpired() {
    this.cookie.deleteAll();
    this.router.navigate(['cookieExpired']);
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
  async doAutoCheck() {
    console.log('autochecked');
  }
}
