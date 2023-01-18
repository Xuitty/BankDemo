import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './login/login.component';
import { NotFoundComponent } from './error/not-found/not-found.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UnknownErrorComponent } from './error/unknown-error/unknown-error.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  { path: '', component: IndexComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registerUser', component: RegisterUserComponent },
  { path: 'main', component: MainComponent },
  { path: '500', component: UnknownErrorComponent },
  { path: '404', component: NotFoundComponent, pathMatch: 'full' },
  { path: '**', redirectTo: '404' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
