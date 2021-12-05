package tn.esprit.services;

import tn.esprit.model.AddToCart;

import java.util.List;

public interface CartService {
List <AddToCart> addCartByUserAndProductId(long idProduit,long userId,int qty,double price)throws Exception;
  List <AddToCart>  getCartByUserId(long id);
  List <AddToCart> removeCartByUserId(long cartId,long id);
  void UpdateQuantityByCartId(long cartId  ,double price ,int qty) throws Exception;
  //Checkout

}
