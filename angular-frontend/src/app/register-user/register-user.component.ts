import { Component, ElementRef, Input, ViewChild, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from '../entity/account';
import { User } from '../entity/user';
import { Decimal } from 'decimal.js';
import SERVER from '../../assets/json/config.json';
import { lastValueFrom } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import { Status } from '../entity/status';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css'],
})
export class RegisterUserComponent implements OnInit {
  constructor(
    private http: HttpClient,
    private cookie: CookieService,
    private router: Router
  ) {}
  @ViewChild('uname') unameNative?: ElementRef;
  @ViewChild('upassword') upasswordNative?: ElementRef;
  @ViewChild('urealname') urealnameNative?: ElementRef;
  @ViewChild('uemail') uemailNative?: ElementRef;
  @ViewChild('utelephone') utelephoneNative?: ElementRef;
  @ViewChild('uaddress') uaddressNative?: ElementRef;
  // @ViewChild('usex') usexNative?: ElementRef;
  usex: number = 1;
  @ViewChild('udate') udateNative?: ElementRef;
  @ViewChild('uidentity') uidentityNative?: ElementRef;

  @ViewChild('uverify') uverifyNative?: ElementRef;

  server: string = JSON.parse(JSON.stringify(SERVER)).url;
  action: string = 'register';
  message: string = '';

  verify_uname: string = '';

  ngOnInit(): void {
    if (this.cookie.check('username')) {
      this.router.navigate(['main']);
    }
  }
  async doRegisterUser() {
    this.message = '資料處理中請稍候...';

    let uname: string = this.unameNative?.nativeElement.value;
    let upassword: string = this.upasswordNative?.nativeElement.value;
    let urealname: string = this.urealnameNative?.nativeElement.value;
    let uemail: string = this.uemailNative?.nativeElement.value;
    let utelephone: string = this.utelephoneNative?.nativeElement.value;
    let uaddress: string = this.uaddressNative?.nativeElement.value;
    // let usex: number = this.usexNative?.nativeElement.value;
    let usex = this.usex;
    let udate: string = this.udateNative?.nativeElement.value;
    let uidentity: string = this.uidentityNative?.nativeElement.value;
    let user: User = new User();
    user.uname = uname == '' ? undefined : uname;
    user.upassword = upassword == '' ? undefined : upassword;
    user.urealname = urealname == '' ? undefined : urealname;
    user.uemail = uemail == '' ? undefined : uemail;
    user.utelephone = utelephone == '' ? undefined : utelephone;
    user.uaddress = uaddress == '' ? undefined : uaddress;
    user.usex = usex;
    user.udate = udate == '' ? undefined : udate;
    user.uidentity = uidentity == '' ? undefined : uidentity;
    let body = user;
    // console.log(user);
    let options = {
      observe: 'response' as 'response',
      responseType: 'text' as 'text',
    };
    console.log(body);

    let ajax = lastValueFrom(
      this.http.post<Status>(this.server + 'registerUser', body)
    );
    let r: boolean;
    let result: Status;
    await ajax.then(
      (res) => {
        console.log(res);

        result = res;
        r = true;
      },
      (reject) => {
        console.log(reject);
        r = false;
        location.href = './500';
      }
    );
    if (!r! || result!.statuss == 3) {
      if (
        result!.message == 'emailAddressError' ||
        result!.message == 'emailError'
      ) {
        this.message = '信箱不正確';
      }
      return;
    }
    this.action = 'verify';
    this.verify_uname = uname;
    this.message = '';
  }

  async doVerifyUser() {
    let body = {
      uname: this.verify_uname,
      uverify: this.uverifyNative?.nativeElement.value,
    };
    let r: boolean;
    let result: Status;
    await lastValueFrom(
      this.http.post<Status>(this.server + 'verifyUser', body)
    ).then(
      (res) => {
        r = true;
        result = res;
      },
      (reject) => {
        console.log(reject);
        r = false;
        location.href = './500';
      }
    );
    if (!r! || result!.statuss == 3) {
      console.log(result!.message);

      return;
    }
    this.cookie.set('username', result!.message!, 0.006944);
    location.href = './main';
  }

  sexSelector(sex: number) {
    this.usex = sex;
  }
}
