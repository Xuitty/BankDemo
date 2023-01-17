import { Component, ElementRef, Input, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from '../entity/account';
import { User } from '../entity/user';
import { Decimal } from 'decimal.js';
import server from '../../assets/json/config.json';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css'],
})
export class RegisterUserComponent {
  constructor(private http: HttpClient) {}
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

  doRegisterUser() {
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
    user.uname = uname;
    user.upassword = upassword;
    user.urealname = urealname;
    user.uemail = uemail;
    user.utelephone = utelephone;
    user.uaddress = uaddress;
    user.usex = usex;
    user.udate = udate;
    user.uidentity = uidentity;

    let json: any = JSON.stringify(server);
    json = JSON.parse(json);

    console.log(json.url);
    // this.http.post();
  }

  sexSelector(sex: number) {
    this.usex = sex;
  }
}
