import {
  Component,
  AfterViewInit,
  OnDestroy,
  resolveForwardRef,
  OnInit,
  ViewChild,
  ElementRef,
} from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Route, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from '../entity/user';
import SERVER from '../../assets/json/config.json';
import { lastValueFrom } from 'rxjs';
import { Status } from '../entity/status';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements AfterViewInit, OnDestroy, OnInit {
  constructor(
    private cookie: CookieService,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    if (this.cookie.check('username')) {
      this.router.navigate(['main']);
    }
  }

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  message?: string = '　';

  registerSlogan: string = '立即加入領取神秘小禮物';
  ticker: string = '　';
  counter?: any;
  async ngAfterViewInit() {
    let t: number = 0;
    let a: number = 0;
    this.counter = setInterval(async () => {
      if ((t < this.registerSlogan.length || t == 0) && a == 0) {
        this.ticker += this.registerSlogan.charAt(t);
        t++;
        // console.log(t);
      } else {
        let t_temp = t;
        // if (t == t_temp) {
        //   let p = await new Promise<string>((resolve, reject) => {
        //     this.delay(resolve, reject);
        //   });

        // }
        a = 1;
        this.ticker = this.ticker.substring(1, this.ticker.length);
        t--;
        if (t == -1) {
          t = 0;
          a = 0;
          this.ticker = '';
        }

        // console.log(t);
      }
    }, 200);
  }

  ngOnDestroy(): void {
    clearInterval(this.counter);
  }

  // delay(resolve: any, reject: any) {
  //   let t: number = 0;
  //   let temp: string = this.ticker;
  //   let timer = setInterval(() => {
  //     if (t < 6) {
  //       if (t % 2 == 0) {
  //         this.ticker = '';
  //         t++;
  //         console.log(t);
  //       } else {
  //         this.ticker = temp;
  //         t++;
  //         console.log(t);
  //       }
  //     } else {
  //       console.log('123' + t);
  //       this.ticker = temp;
  //       clearInterval(timer);
  //       return resolve('success');
  //     }
  //   }, 500);
  // }

  goRegisterUser() {
    location.href = './registerUser';
  }

  @ViewChild('uname') uname?: ElementRef;
  @ViewChild('upassword') upassword?: ElementRef;

  async doLogin() {
    let uname = this.uname?.nativeElement.value;
    let upassword = this.upassword?.nativeElement.value;

    if (uname == '' || upassword == '') {
      this.message = '請輸入帳號密碼';
      return;
    }
    let user: User = new User(uname, upassword);
    let result: Status = new Status();
    await lastValueFrom(
      this.http.post<Status>(this.server + 'userLogin', user)
    ).then(
      (res) => {
        result = res;
      },
      (reject) => {
        console.log(reject);
        return;
      }
    );
    if (result.statuss == 1) {
      this.cookie.set('username', result.message!, 0.006944);
      this.router.navigate(['main']);
    } else if (result.statuss == 3 && result.message == 'accPassError') {
      this.message = '帳號密碼錯誤';
    } else if (result.statuss == 3 && result.message == 'verifyError') {
      this.message = '帳號未驗證啟用';
    } else {
      this.message = '未知的錯誤';
    }
  }
}
