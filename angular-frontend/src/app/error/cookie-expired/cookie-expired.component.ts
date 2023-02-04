import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-cookie-expired',
  templateUrl: './cookie-expired.component.html',
  styleUrls: ['./cookie-expired.component.css'],
})
export class CookieExpiredComponent implements OnInit {
  constructor(private router: Router, private cookie: CookieService) {}
  message?: string;
  async ngOnInit() {
    this.cookie.deleteAll();
    let counter = 6;
    await new Promise<void>((res) => {
      let timer = setInterval(() => {
        counter--;
        this.message =
          '登入已過期<br><br>將於' + counter + '秒後導向至登入頁面';
        if (counter == 0) {
          clearInterval(timer);
          res();
        }
      }, 1000);
    });
    this.router.navigate(['login']);

    return;
  }
}
