import { Component, OnInit } from '@angular/core';
import { faCoffee,faShoppingCart,faHeart,faPlus,faExpand } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
  faCoffee = faCoffee;
  faShoppingCart=faShoppingCart;
  faHeart=faHeart;
  faPlus=faPlus;
  faExpand=faExpand;
  hide:boolean=false;

  constructor() { }

  ngOnInit(): void {
    this.hide=true;
    localStorage.setItem('hide',String(this.hide));
  }

}
