import {
  Component,
  AfterViewInit,
  OnDestroy,
  resolveForwardRef,
} from '@angular/core';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements AfterViewInit, OnDestroy {
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
}
