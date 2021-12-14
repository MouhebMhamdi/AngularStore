import { Component, OnChanges, OnDestroy, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { Users } from 'src/app/core/model/Users';
import { AuthentificationService } from 'src/app/core/service/authentification.service';
import {CartServiceService} from "../../core/service/Cart/cart-service.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit,OnChanges {
  users: Users;
  hide:boolean;
  data:any;
  cart_qty = 0;
  cartObj = [];
  itemInCart:number;

  constructor(public router: Router,private authService:AuthentificationService,private cartService:CartServiceService) {

/*
    this.cartService.cartServiceEvent.subscribe(data=>{
      this.cartObj =  this.cartService.getCartOBj();
      this.cart_qty = this.cartService.getQty();
    })*/
  }

  ngOnInit(): void {


    this.cartService.cartItems.subscribe(d=>{
      this.itemInCart=d.length;
      console.log(d)
    })






    this.verifUserRoleConncet(String(localStorage.getItem("email")))
    this.authService.sharedUser.subscribe(
      (data:Users)=>
      {this.users=data},
      ()=>{},
      ()=>{this.users = new Users()}
    )

      this.data=localStorage.getItem("data");
  }

  ngOnChanges():void{
    this.authService.sharedUser.subscribe(
      (data:Users)=>
      {this.users=data},
      ()=>{},
      ()=>{this.users = new Users()}
    )

  }
  verifUserRoleConncet(email:string){


    this.authService.getUserConnect(String(email)).subscribe(user =>{

     console.log(user+"ezeeze")



}

)
}
  logout(){
   this.authService.logOut();
   this.users=new Users();

  }
  hasRoute(route: string) {
    return this.router.url.includes(route);
  }





}
