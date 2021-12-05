package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.AddToCartRepository;
import tn.esprit.model.AddToCart;
import tn.esprit.model.Produit;

import java.util.List;
@Service
public class CarteServiceImpl implements  CartService{

  @Autowired
  AddToCartRepository addToCartRepository;

  @Autowired
  ProduitService produitService;

  @Override
 public List<AddToCart> addCartByUserAndProductId(long productId, long userId,int qty,double price)throws Exception {
    try {
       if( addToCartRepository.getCartByProductIdAnduserId(productId,userId).isPresent())
       {
         throw  new Exception("Product is alrady exist !");
       }
      AddToCart obj=new AddToCart();
      obj.setQty(qty);
      obj.setUser_id(userId);
      Produit p=produitService.getProduitById(productId);
      obj.setProduit(p);
      //TO DO price has to been checked with quantity
      obj.setPrice(price);
      addToCartRepository.save(obj);
      return getCartByUserId(userId);
    }catch (Exception e){

throw new Exception(e.getMessage());
    }


  }

  @Override
  public List<AddToCart> getCartByUserId(long userId) {
    return addToCartRepository.getCartByuserId(userId);
  }

  @Override
  public List<AddToCart> removeCartByUserId(long cartId,long userId) {
    addToCartRepository.deleteCartByIdAndUserId(userId,cartId);
    return  this.getCartByUserId(userId);
  }

  @Override
  public void UpdateQuantityByCartId(long cartId,double price,  int qty) throws Exception {
addToCartRepository.updateQtyByCartId(cartId,price,qty);
  }


}
