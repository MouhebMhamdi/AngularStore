import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {BehaviorSubject, Observable, throwError} from "rxjs";
import {HttpServiceService} from '../http-service.service';
import {Users} from "../../model/Users";
import {catchError} from "rxjs/operators";
import {Carts} from "../../model/Cart";
import {Product} from "../../model/product";

@Injectable({
  providedIn: 'root'
})
export class CartServiceService {
  url = "http://localhost:8080/api/addtocart";
  placeholder = [];
  cartTotalPrice :any
  cartItems=new BehaviorSubject([]);
  public cartServiceEvent=new BehaviorSubject({});
  constructor(private http:HttpServiceService,private https:HttpClient) {
    /*  this.getCartDetailsByUser();*/
  // @ts-ignore
    const ls=this.getCartData();
if (ls) this.cartItems.next(ls);

  }



  AddItems(product:Product){
    // @ts-ignore
    const ls=this.getCartData();
let exist:Product;

if (ls)
   // @ts-ignore
    exist=ls.find((item)=>{
          // @ts-ignore
          return  item.idProduit==product.idProduit;
        });

// @ts-ignore
if(exist)
  { // @ts-ignore
    exist.qty++;
this.setCartData(ls);
  } else {
          if (ls){
            const newData=[...ls,product];
            // localStorage.setItem('cart',JSON.stringify(newData));
            this.setCartData(newData);

            // @ts-ignore
            this.cartItems.next(this.getCartData());
          }
            // @ts-ignore
            this.placeholder.push(product);
          this.setCartData(this.placeholder);


}


  }


  setCartData(data:any){
    localStorage.setItem('cart',JSON.stringify(data));
    this.cartItems.next(this.getCartData());
  }
getCartData(){

    // @ts-ignore
  return JSON.parse(localStorage.getItem('cart'));
}









/*
  getCartDetailsByUser(){
    this.http.postRequestWithToken("api/addtocart/getCartsByUserId",{}).subscribe((data:any)=>{
      //alert("Error while fetching the cart Details");
      this.cartObj = data;
      this.cartQty = data.length;
      this.cartTotalPrice = this.getTotalAmounOfTheCart();
      this.cartServiceEvent.next({"status":"completed"})//emitter
    },error=>{
      alert("Error while fetching the cart Details");
    })
  }*/

/*

  addCart(obj:any){
    //this.cartServiceEvent.next({"status":"completed"})//emitter
    var request  = {
      "productId":obj.productId,
      "qty":obj.qty,
      "price":obj.price
    }
   return  this.https.post(this.url+"/addproduct",obj,{responseType: 'text'},).subscribe(data=>{
        this.getCartDetailsByUser()
      },
      error=>{
        //if the products is already in cart
        alert("Error in AddCart API "+error.message);
      })
  }
*/


/*  addCart(data:Carts){
    console.log(data)
    return this.https.post(this.url+'addproduct',data,{responseType: 'text'}).pipe(

    );

  }*/
/*  getCartOBj(){
    return this.cartObj;
  }
  getTotalAmounOfTheCart(){
    let obj = this.cartObj;
    let totalPrice  = 0;

    for(var o in obj ){
      // @ts-ignore
      totalPrice = totalPrice +parseFloat(obj[o].price);
    }

    return totalPrice.toFixed(2);
  }
  getQty(){
    return this.cartQty;
  }


  removeCart(cartId:any){
    var request = {
      "productId":"dummy_val",
      "cartId":cartId,
    }
    this.http.postRequestWithToken("api/addtocart/removeProductFromCart",request).subscribe((data:any)=>{
      this.getCartDetailsByUser();
    },error=>{
      alert("Error while fetching the cart Details");
    })
  }*/

}
