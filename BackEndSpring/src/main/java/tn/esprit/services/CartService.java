package tn.esprit.services;

import tn.esprit.model.AddToCart;

import java.util.List;

public interface CartService {
List <AddToCart> addCartByUserAndProduct(long productId,long userId);
  List <AddToCart>  getCartByUserId(long id);
  List <AddToCart> removeCartByUserId(long id);
  //Checkout

}
