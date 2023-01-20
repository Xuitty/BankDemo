import { Component, OnDestroy } from '@angular/core';
import { TimeInterval } from 'rxjs/internal/operators/timeInterval';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css'],
})
export class IndexComponent implements OnDestroy {
  title: string = '金發財商業銀行網路銀行';
  blinker: string = 'btn btn-warning';
  counter?: any;
  ngOnDestroy(): void {
    this.btnLoginAnimationStop();
  }
  goLogin() {
    location.href = './login';
  }

  btnLoginAnimation() {
    let t: number = 0;

    this.counter = setInterval(() => {
      t++;
      if (t % 2 == 1) {
        this.blinker = 'btn btn-danger';
      } else {
        this.blinker = 'btn btn-warning';
      }
    }, 200);
  }
  btnLoginAnimationStop() {
    clearInterval(this.counter);
    this.blinker = 'btn btn-warning';
  }
}
