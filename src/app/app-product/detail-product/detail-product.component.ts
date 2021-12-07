import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProductService} from "../../core/service/produit/product.service";
import {Product} from "../../core/model/product";

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {
  product: Product;
  hide :boolean = false;

  constructor(private route: ActivatedRoute,private router: Router, private productService: ProductService) { }
  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('idProduit'));
    if (id) {
      this.getProduct(id);
    }

  }


  getProduct(id: number) :void {
    this.productService.getProduct(id).subscribe(data => {
      this.product = data;
    });
  }


}
