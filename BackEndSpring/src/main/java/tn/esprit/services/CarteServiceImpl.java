package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.Repositories.AddToCartRepository;
import tn.esprit.model.AddToCart;

import java.util.List;

public class CarteServiceImpl implements  CartService{

  @Autowired
  AddToCartRepository addToCartRepository;

  //@Override
/*  public List<AddToCart> addCartByUserAndProductId(long productId, long userId,int qty,double price) {
    AddToCart obj=new AddToCart();
    obj.setQty(qty);
    obj.setUser_id(userId);
    obj.setProduct_id(productId);
    obj.setPrice(price);
    addToCartRepository
  }*/

  @Override
  public List<AddToCart> addCartByUserAndProductId(long productId, long userId, int qty, double price) {
    return null;
  }

  @Override
  public List<AddToCart> getCartByUserId(long id) {
    return null;
  }

  @Override
  public List<AddToCart> removeCartByUserId(long id) {
    return null;
  }
}
