import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {CartService} from "./core/service/cart.service";
import {CartServiceService} from "./core/service/Cart/cart-service.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Atelier2';
itemInCart:number;
  constructor(private router: Router,private Http:HttpClient,private cartService:CartServiceService) {

  }

  ngOnInit(){

  }


}
