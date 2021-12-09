package tn.esprit.Controller;

import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.JWTConfiguration.ShoppingConfiguration;
import tn.esprit.model.AddToCart;
import tn.esprit.model.CheckOutCart;
import tn.esprit.services.CartService;
import tn.esprit.services.ProduitService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/order")
public class OrderController {

  @Autowired
  CartService cartService;
  ProduitService produitService;

  @RequestMapping("checkout_order")
  public ResponseEntity<?> checkout_order(@RequestBody HashMap<String,String> addCartRequest) {
    try {
      String keys[] = {"userId","total_price","pay_type","deliveryAddress"};
      if(ShoppingConfiguration.validationwithHashmap(keys, addCartRequest)) {


      }
      long user_Id = Long.parseLong(addCartRequest.get("userId"));
      double total_amt = Double.parseDouble(addCartRequest.get("total_price"));
      if(cartService.checkTotalAmount(total_amt,user_Id)) {
        List<AddToCart> cartItems = cartService.getCartByUserId(user_Id);
        List<CheckOutCart> tmp = new ArrayList<>();
        for(AddToCart addCart : cartItems) {
          String orderId = ""+getOrderId();
          CheckOutCart cart = new CheckOutCart();
          cart.setPayment_type(addCartRequest.get("payment_type"));
          cart.setPrice(total_amt);
          cart.setUser_id(user_Id);
          cart.setOrder_id(orderId);
          cart.setProduct(addCart.getProduit());
          cart.setQty(addCart.getQty());
          cart.setDelivery_address(addCartRequest.get("deliveryAddress"));
          tmp.add(cart);
        }
        cartService.saveProductsForCheckout(tmp);
        return ResponseEntity.ok("Order placed successfully");
      }else {
        throw new Exception("Total amount is mismatch");
      }
    }catch(Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("");
    }
  }
  public int getOrderId() {
    Random r = new Random( System.currentTimeMillis() );
    return 10000 + r.nextInt(20000);
  }
  @RequestMapping("getOrdersByUserId")
  public ResponseEntity<?> getOrdersByUserId(@RequestBody HashMap<String,String> ordersRequest) {
    try {
      String keys[] = {"userId"};
      return ResponseEntity.ok("Order placed successfully");
    }catch(Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("");
    }

  }


  }

