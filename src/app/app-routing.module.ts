import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ContactComponent} from "./contact/contact.component";
import {AboutComponent} from "./about/about.component";
import {NotFoundComponent} from "./app-shared/not-found/not-found.component";
import {CommonModule} from "@angular/common";
import {ContentComponent} from "./content/content.component";
import {CheckoutComponent} from "./checkout/checkout.component";
import {AppCartComponent} from "./app-cart/app-cart.component";
import { LoginComponent } from './authentificationAndRegister/login/login.component';
import { LogoutComponent } from './authentificationAndRegister/logout/logout.component';
import { ResetPasswordComponent } from './authentificationAndRegister/reset-password/reset-password.component';

const routes: Routes = [
  {path: '', component: ContentComponent},
  {path:'contact', component: ContactComponent},
  {path:'about', component: AboutComponent},
  {path:'content', component: ContentComponent},
  {path:'checkout', component: CheckoutComponent},
  {path:'cart', component: AppCartComponent},
  {path:'login',component:LoginComponent},
  {path:'logout',component:LogoutComponent},
  {path:'newPassword',component:ResetPasswordComponent},
  {path: '**',component: NotFoundComponent }

];

@NgModule({
  imports: [CommonModule,RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
