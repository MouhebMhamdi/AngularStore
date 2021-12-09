import { Component, OnInit } from '@angular/core';
import {Product} from "../../core/model/product";
import {Router} from "@angular/router";
import {ProductService} from "../../core/service/produit/product.service";
import {stringify} from "@angular/compiler/src/util";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products: Product[];
  p: number = 1;
  constructor(private router: Router, private productService: ProductService) {
  }

  ngOnInit(): void {
    this.listPoducts();

  }


  listPoducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }


}
