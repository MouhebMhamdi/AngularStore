package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.AddToCartRepository;
import tn.esprit.Repositories.OrderRepository;
import tn.esprit.model.AddToCart;
import tn.esprit.model.CheckOutCart;
import tn.esprit.model.DetailProduit;
import tn.esprit.model.Produit;

import java.util.List;
@Service
public class CarteServiceImpl implements  CartService {
//12-09
  @Autowired
  AddToCartRepository addToCartRepository;
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  ProduitService produitService;

  @Override
  public List<AddToCart> addCartByUserAndProductId(long productId, long userId, int qty, double price) throws Exception {
    try {
      if (addToCartRepository.getCartByProductIdAnduserId(productId, userId).isPresent()) {
        throw new Exception("Product is alrady exist !");
      }
      AddToCart obj = new AddToCart();
      obj.setQty(qty);
      obj.setUser_id(userId);
      Produit p = produitService.retrieveProduit(productId);
      obj.setProduit(p);
      //TO DO price has to been checked with quantity
      obj.setPrice(price);
      addToCartRepository.save(obj);
      return getCartByUserId(userId);
    } catch (Exception e) {

      throw new Exception(e.getMessage());
    }


  }

  @Override
  public List<AddToCart> getCartByUserId(long userId) {
    return addToCartRepository.getCartByuserId(userId);
  }

  @Override
  public String deletproductfromcart(Long productId) {
    addToCartRepository.deleteById(productId);
    return "product deleted";
  }

/*
  @Override
  public List<AddToCart> removeCartByUserId(long cartId,long userId) {
    addToCartRepository.deleteCartByIdAndUserId(cartId,userId);
    return  this.getCartByUserId(userId);
  }
*/


  @Override
  public List<AddToCart> removeCartByUserId(long cartId, long userId) {
    addToCartRepository.deleteCartByIdAndUserId(userId, cartId);
    return this.getCartByUserId(userId);
  }


  @Override
  public void UpdateQuantityByCartId(long cartId, double price, int qty) throws Exception {
    addToCartRepository.updateQtyByCartId(cartId, price, qty);
  }

  @Override
  public Boolean checkTotalAmount(double totalAmount, long userId) {
    double total_amount = addToCartRepository.getTotalAmountByUserId(userId);
    if (total_amount == totalAmount) {
      return true;
    }
    System.out.println("Error" + total_amount + "" + totalAmount);
    return false;
  }

  @Override
  public List<CheckOutCart> getAllCheckoutByUserId(long userId) {
    return null;
  }

  @Override
  public List<CheckOutCart> saveProductsForCheckout(List<CheckOutCart> tmp) throws Exception {
    try {
      long user_id = tmp.get(0).getUser_id();
      if (tmp.size() > 0) {
        orderRepository.saveAll(tmp);
        this.removeAllCartByUserId(user_id);
        return this.getAllCheckoutByUserId(user_id);
      } else {
        throw new Exception("Should not be empty");
      }
    } catch (Exception e) {
      throw new Exception("Error while checkout " + e.getMessage());
    }

  }

  @Override
  public List<AddToCart> removeAllCartByUserId(long userId) {
    addToCartRepository.deleteAllCartByUserId(userId);
    return null;

  }


  @Override
  public AddToCart addproductbyuseridandproductid(AddToCart addToCart, Long userId, Long ProductId,double price,int qty) {
    addToCart.setQty(qty);
    addToCart.setPrice(price);
    addToCart.setUser_id(userId);


    addToCartRepository.save(addToCart);
    return addToCart;
  }




}
