import {
  Component,
  OnInit,
  OnDestroy,
  Output,
  ViewChild,
  ElementRef,
} from '@angular/core';
import {
  NavigationCancel,
  NavigationEnd,
  NavigationError,
  NavigationStart,
  Router,
  Event as RouterEvent,
} from '@angular/router';
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
    height: window.screen.availHeight - 80 + 'px',
    width: window.screen.availWidth - 50 + 'px',
  };
  loading: boolean = true;

  constructor(private bgService: BgServiceService, private router: Router) {
    router.events.subscribe((event: RouterEvent) => {
      // console.log(event);

      this.navigationInterceptor(event);
    });
  }
  navigationInterceptor(event: RouterEvent): void {
    if (event instanceof NavigationStart) {
      this.loading = true;
    }
    if (event instanceof NavigationEnd) {
      setTimeout(() => {
        // here
        this.loading = false;
      }, 50);
    }

    // Set loading state to false in both of the below events to hide the spinner in case a request fails
    if (event instanceof NavigationCancel) {
      setTimeout(() => {
        // here
        this.loading = false;
      }, 50);
    }
    if (event instanceof NavigationError) {
      setTimeout(() => {
        // here
        this.loading = false;
      }, 50);
    }
  }

  ngOnInit(): void {
    this.bgSubscription = this.bgService.bgPath.subscribe((bgPath) => {
      this.style['background-image'] = 'url(' + bgPath + ')';
    });
    console.log(this.style);
  }

  ngOnDestroy(): void {
    this.bgService.bgPath.unsubscribe();
    // AppComponent.loadingSwitchOn();
  }
  loadingSwitch = 'none';
  public loadingOn() {
    this.loading = true;
  }
  public loadingOff() {
    setTimeout(() => {
      this.loading = false;
    }, 50);
  }
}
