import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FooterComponent } from './app-shared/footer/footer.component';
import { ContentComponent } from './content/content.component';
import { HeaderComponent } from './app-shared/header/header.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule } from '@angular/common/http';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CheckoutComponent } from './checkout/checkout.component';
import { LoginComponent } from './authentificationAndRegister/login/login.component';
import { MainProductsComponent } from './app-product/main-products/main-products.component';
import { FormProductsComponent } from './app-product/form-products/form-products.component';
import { AppProductComponent } from './app-product/app-product.component';
import { ProductsComponent } from './app-product/products/products.component';
import { AppCartComponent } from './app-cart/app-cart.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LogoutComponent } from './authentificationAndRegister/logout/logout.component';
import { NgxSpinnerModule } from "ngx-spinner";
import { ResetPasswordComponent } from './authentificationAndRegister/reset-password/reset-password.component';
import { AboutComponent } from './about/about.component';
import { NotFoundComponent } from './app-shared/not-found/not-found.component';
import { AppSharedComponent } from './app-shared/app-shared.component';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    AppComponent,
    ContentComponent,
    FooterComponent,
    HeaderComponent,
    ContactComponent,
    AboutComponent,
    NotFoundComponent,
    CheckoutComponent,
    AppCartComponent,
    ProductsComponent,
    AppProductComponent,
    FormProductsComponent,
    MainProductsComponent,
    AppSharedComponent,
    LoginComponent,
    LogoutComponent,
    ResetPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule,
    FontAwesomeModule,
    NgbModule,
    NgxSpinnerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
