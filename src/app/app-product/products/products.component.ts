import { Component, OnInit } from '@angular/core';
import {Product} from "../../core/model/product";
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../core/service/produit/product.service";
import {stringify} from "@angular/compiler/src/util";
import {CartServiceService} from "../../core/service/Cart/cart-service.service";
import {HttpServiceService} from "../../core/service/http-service.service";
import {Carts} from "../../core/model/Cart";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  product: Product;

  categoryList: any;
  productsList: any;
  p: number = 1;

  constructor(private  route:ActivatedRoute,private router: Router, private productService: ProductService, private cartService: CartServiceService) {
  }


  ngOnInit() {
    this.listPoducts();
    const id= +this.route.snapshot.params['id'];
    // @ts-ignore
    this.product=this.productService.getProduct(id);


 /*  this.http.postRequestWithToken("api/produit/getAllProduits", {}).subscribe(data => {
      this.categoryList = data;
      if (this.categoryList.length > 1) { // @ts-ignore
        this.getProductsByCateogy(products[0])
      }
    }, error => {
      alert("Server connection error " + error)
    })*/
  }
/*  getProductsByCateogy(obj:any){
    let request ={
      "cat_id":obj.id
    }
    this.http.postRequestWithToken('api/produit/getAllProduits',request).subscribe(products=>{
      this.productsList = products
      if(this.productsList.length == 0){
        alert("No Product is found..");
      }
    },error=>{
      alert("Error in login "+error);
    })
  }*/

 /* addCart(cartProductObj:any){
    let data={
      "productId":cartProductObj.productId,
      "Qty":"1",
      "price":cartProductObj.price,

    }
    this.cartService.addCart(Carts);

  }*/

  listPoducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  addtocart(product:Product){
this.cartService.AddItems(product)

  }




}
