import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from '../entity/account';
import { User } from '../entity/user';
import { Decimal } from 'decimal.js';
import SERVER from '../../assets/json/config.json';
import { lastValueFrom } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css'],
})
export class RegisterUserComponent {
  constructor(private http: HttpClient, private cookie: CookieService) {}
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

  async doRegisterUser() {
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
    // console.log(body);

    let ajax = lastValueFrom(
      this.http.post(this.server + 'registerUser', body, {
        responseType: 'text',
      })
    );
    let r: boolean;
    let result: string;
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
    if (!r! || result! !== 'success') {
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
    let result: User;
    await lastValueFrom<User>(
      this.http.post(this.server + 'verifyUser', body)
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
    if (!r! || result!.uid == null || result!.uid == undefined) {
      console.log('failed');

      return;
    }
    this.cookie.set('username', result!.ucookie!, 0.006944);
  }

  sexSelector(sex: number) {
    this.usex = sex;
  }
}
