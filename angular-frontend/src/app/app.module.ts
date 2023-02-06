import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { HttpClient } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { BgServiceService } from './bg-service.service';
import { LoginComponent } from './login/login.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { HttpClientModule } from '@angular/common/http';
import { MainComponent } from './main/main.component';
import { UnknownErrorComponent } from './error/unknown-error/unknown-error.component';
import { NotFoundComponent } from './error/not-found/not-found.component';
import { TimerService } from './services/timer/timer.service';
import { CookieService } from 'ngx-cookie-service';
import { CookieExpiredComponent } from './error/cookie-expired/cookie-expired.component';
import { NgChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    RegisterUserComponent,
    MainComponent,
    UnknownErrorComponent,
    NotFoundComponent,
    CookieExpiredComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, NgChartsModule],
  providers: [TimerService, CookieService],
  bootstrap: [AppComponent],
})
export class AppModule {}
