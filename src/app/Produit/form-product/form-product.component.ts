import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Product} from "../../core/model/product";
import {ProductService} from "../../core/service/produit/product.service";

@Component({
  selector: 'app-form-product',
  templateUrl: './form-product.component.html',
  styleUrls: ['./form-product.component.scss']
})
export class FormProductComponent implements OnInit {
  form : FormGroup;
  private product: Product;
  file:File;

  @Output() addEvent = new EventEmitter<Product>()
  @Input() updateProduct : Product;

  constructor(private builder : FormBuilder,private productService: ProductService) { }

  ngOnInit(): void {
    if (this.updateProduct === null){
      this.product = new Product();
    }
    else {
      this.product = this.updateProduct;
    }

    this.form = this.builder.group({
      'title' : [this.product.libelle, [Validators.required, Validators.minLength(5)]],
      'price' : [this.product.prixUnitaire, [Validators.required, Validators.min(10)]],
      'picture' : [this.product.image, Validators.required],

    });
  }

  addProduct(form : FormGroup){
    this.product.libelle       = form.value.title;
    this.product.prixUnitaire = form.value.price;
    this.product.image     = form.value.picture;
    this.addEvent.emit(this.product);
  }
  onFileSelected(event:any) {
    this.file = event.target.files[0];
  }
  UploadImg(id:any){
   this.productService.UploadImage(this.file,id).subscribe((res)=>{
    })
  }
}
