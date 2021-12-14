import { Component, OnInit } from '@angular/core';
import {Product} from "../../core/model/product";
import {ProductService} from "../../core/service/produit/product.service";

@Component({
  selector: 'app-main-product',
  templateUrl: './main-product.component.html',
  styleUrls: ['./main-product.component.scss']
})
export class MainProductComponent implements OnInit {
  listProduct: Product[];
  inputProduct : Product = new Product();
  showFormTemplate: boolean;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.showFormTemplate = false;
    this.productService.getListProduct().subscribe(
      (data:Product[])=> this.listProduct=data
    )
  }

  saveProduct(product: Product) {
    let i = this.listProduct.indexOf(product);
    if (i!= -1){
      //update a product
      this.productService.updateProduct(product).subscribe(
        ()=>this.listProduct[i]=product
      )
    }else {
      //add a new product
      this.productService.addProduct(product).subscribe(
        ()=>this.listProduct.push(product),
        ()=>console.log('error')
      )

    }
    this.showFormTemplate = false;
  }
  showForm(){
    this.showFormTemplate =true
  }
  delete(p:Product){
    let i = this.listProduct.indexOf(p);
    this.productService.deleteProduct(p.idProduit).subscribe(
      ()=>this.listProduct.splice(i,1)
    )
  }
  updateForm(p:Product){
    this.showFormTemplate=true;
    this.inputProduct = p;


  }
}
