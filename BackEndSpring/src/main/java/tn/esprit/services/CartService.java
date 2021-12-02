package tn.esprit.services;

import tn.esprit.model.AddToCart;

import java.util.List;

public interface CartService {
List <AddToCart> addCartByUserAndProductId(long productId,long userId,int qty,double price);
  List <AddToCart>  getCartByUserId(long id);
  List <AddToCart> removeCartByUserId(long id);
  //Checkout

}
