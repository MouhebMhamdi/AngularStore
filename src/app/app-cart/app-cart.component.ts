import { Component, OnInit } from '@angular/core';
import {Product} from "../core/model/product";
import {CartServiceService} from "../core/service/Cart/cart-service.service";

@Component({
  selector: 'app-app-cart',
  templateUrl: './app-cart.component.html',
  styleUrls: ['./app-cart.component.css']
})
export class AppCartComponent implements OnInit {

 // items = this.cartService.getItems();
cartObj=[];
items:Product[]=[];
  total:number=0;
  constructor(private cartService:CartServiceService) { }
  ngOnInit(): void {
    this.cartService.cartItems.subscribe(data=>{
this.items=data;
    })
    this.getTotal(this.items);


  }


onDelet(i:number){
    this.items.splice(i,1);
  this.getTotal(this.items);

}

  validationInput(event:any,i:number){
    const qty=+event.target.value;
if(qty<1){
  event.target.value=this.items[i].qty;
return;
}
this.UpdateQty(qty,i);
  }

private  UpdateQty(qty:number,i:number){
    this.items[i].qty=qty;
this.cartService.setCartData(this.items)
  this.getTotal(this.items)
  }



removeAllProduct(){
localStorage.removeItem('cart');
this.getCatDetails=[];
}



getCatDetails:any=[];
  CartDetails(){
    if(localStorage.getItem('cart')){
      // @ts-ignore
      this.getCatDetails=JSON.parse(localStorage.getItem('cart'));
      console.log(this.getCatDetails);
    }
  }






  //hedhi li aandou howa opencheckoutModel fel head ts

/*  addCart(cartProductObj:any){
    var cartObj = {
      "productId":cartProductObj.id,
      "qty":"1",
      "price":cartProductObj.price
    }
    this.cartService.addCart(cartObj);
  }
  getProductsByCateogy(obj:any) {
    let request = {
      "cat_id": obj.id
    }
  }*/

getTotal(data:any){
let subs=0
  // @ts-ignore
  for(const item of data){
    subs+=item.price*item.qty
this.total=subs;
  }
}

}
