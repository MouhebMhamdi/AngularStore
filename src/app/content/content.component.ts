import { Component, OnInit } from '@angular/core';
import { faCoffee,faShoppingCart,faHeart,faPlus,faExpand } from '@fortawesome/free-solid-svg-icons';
import {UserService} from "../core/service/user.service";
import {Product} from "../core/model/product";
import {Observable} from "rxjs";
import {Router} from "@angular/router";

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
