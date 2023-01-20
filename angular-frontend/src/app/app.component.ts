import { Component, OnInit, OnDestroy, Output } from '@angular/core';
import { Subscription } from 'rxjs';
import { BgServiceService } from './bg-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, OnDestroy {
  bgSubscription?: Subscription;
  title = 'angular-frontend';
  style = {
    'background-image': 'url("")',
    height: '100vh',
    width: '100vw',
  };

  constructor(private bgService: BgServiceService) {}

  ngOnInit(): void {
    this.bgSubscription = this.bgService.bgPath.subscribe((bgPath) => {
      this.style['background-image'] = 'url(' + bgPath + ')';
    });
  }

  ngOnDestroy(): void {
    this.bgService.bgPath.unsubscribe;
  }

  test() {
    alert('123');
  }
}
