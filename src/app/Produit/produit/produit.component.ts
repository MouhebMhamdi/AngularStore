import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Product} from "../../core/model/product";

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent implements OnInit {
  @Input() product: Product;
  @Output() notification= new EventEmitter<Product>()
  @Output() deleteEvent = new EventEmitter<Product>()
  @Output() updateEvent = new EventEmitter<Product>()
  constructor() { }

  ngOnInit(): void {
  }
  notifyParent(){
    //traitement
    this.notification.emit(this.product)
  }
  deleteNotif(){
    this.deleteEvent.emit(this.product)
  }
  updateNotif(){
    this.updateEvent.emit(this.product)
  }
}
