package tn.esprit.services;

import tn.esprit.model.AddToCart;
import tn.esprit.model.CheckOutCart;
import tn.esprit.model.Produit;

import java.util.List;

public interface CartService {
List <AddToCart> addCartByUserAndProductId(long idProduit,long userId,int qty,double price)throws Exception;
  List <AddToCart>  getCartByUserId(long id);
  String   deletproductfromcart(Long productId);
  List <AddToCart> removeCartByUserId(long cartId,long id);
  void UpdateQuantityByCartId(long cartId  ,double price ,int qty) throws Exception;
  Boolean checkTotalAmount(double totalAmount,long userId);
  List <CheckOutCart>getAllCheckoutByUserId(long userId);
  List<CheckOutCart> saveProductsForCheckout(List<CheckOutCart> tmp)  throws Exception;
  List<AddToCart> removeAllCartByUserId(long userId);
  public AddToCart addproductbyuseridandproductid(AddToCart addToCart, Long userId, Long ProductId,double price,int qty);  //Checkout

}
