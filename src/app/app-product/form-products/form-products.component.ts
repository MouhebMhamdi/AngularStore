import {Component, Input, OnInit, Output} from '@angular/core';
import {Product} from "../../core/model/product";
import {EventEmitter} from '@angular/core';

@Component({
  selector: 'app-form-products',
  templateUrl: './form-products.component.html',
  styleUrls: ['./form-products.component.css']
})
export class FormProductsComponent implements OnInit {
  @Input() product:Product;
  @Output() addEvent=new EventEmitter<Product>();
  constructor() { }

  ngOnInit(): void {
  }
  save(){
    this.addEvent.emit(this.product);
    this.product = new Product();
  }

}
