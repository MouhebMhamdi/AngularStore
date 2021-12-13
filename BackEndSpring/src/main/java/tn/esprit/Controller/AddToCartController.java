package tn.esprit.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.JWTConfiguration.ShoppingConfiguration;
import tn.esprit.model.AddToCart;
import tn.esprit.model.Produit;
import tn.esprit.services.CartService;
import tn.esprit.services.CarteServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/addtocart")
public class AddToCartController {

  @Autowired
CarteServiceImpl carteService;



  @RequestMapping("addproduct")
  public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
    try {
      String keys[] = {"idProduit","userId","qty","price"};
      if(ShoppingConfiguration.validationwithHashmap(keys, addCartRequest)) {

      }
      long idProduit = Long.parseLong(addCartRequest.get("idProduit"));
      long userId =  Long.parseLong(addCartRequest.get("userId"));
      int qty =  Integer.parseInt(addCartRequest.get("qty"));
      double price = Double.parseDouble(addCartRequest.get("price"));
      List<AddToCart> obj = carteService.addCartByUserAndProductId(idProduit,userId,qty,price);
      return ResponseEntity.ok(obj);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("a");
    }

  }

//jdida
/*  @PostMapping("/addproducttocart/{userId}/{productId}")
  public AddToCart addProductToCart(@RequestBody AddToCart p , @PathVariable(value="productId") long productId, @PathVariable(value="userId") long userId,int qty,double price){
    AddToCart addToCart=carteService.addproductbyuseridandproductid(p,userId,productId,price,qty);
    return addToCart;
  }*/


  @PostMapping("updateqtycart")
  public ResponseEntity<?> updateQuantityForCart(@RequestBody HashMap<String,String> addCartRequest) {
    try {
      String keys[] = {"cartId","userId","qty","price"};// les donneés hedhouma mouch normalemnt lezm njibhom mel front ?
      if(ShoppingConfiguration.validationwithHashmap(keys, addCartRequest)) {

      }
      long cartId = Long.parseLong(addCartRequest.get("cartId"));
      long userId =  Long.parseLong(addCartRequest.get("userId"));
      int qty =  Integer.parseInt(addCartRequest.get("qty"));
      double price = Double.parseDouble(addCartRequest.get("price"));
      carteService.UpdateQuantityByCartId(cartId,price,qty);
      List<AddToCart> obj = carteService.getCartByUserId(userId);
      return ResponseEntity.ok(obj);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("a");
    }

  }
/*

  @ResponseBody
  @DeleteMapping("/removeproductfromcart/{id}")
  public String deletproductfromcart(@PathVariable(value="id") long productId){
    carteService.deletproductfromcart(productId);
  return "deleted";
  }
*/

  @RequestMapping("removeProductFromCart")
  public ResponseEntity<?> removeCartwithProductId(@RequestBody HashMap<String,String> removeCartRequest) {
    try {
      String keys[] = {"userId","cartId"};
      if(ShoppingConfiguration.validationwithHashmap(keys, removeCartRequest)) {

      }
      List<AddToCart> obj = carteService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Long.parseLong(removeCartRequest.get("userId")));
      return ResponseEntity.ok(obj);
    }catch(Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @RequestMapping("/getcartbyuserid")//lena maamlch POST 3awadhha bel getCartRequest ??
  public ResponseEntity<?>getCartByUserId(@RequestBody HashMap<String,String> getCartRequest){
    try {
      String keys[] = {"userId"};
      if(ShoppingConfiguration.validationwithHashmap(keys, getCartRequest)) {
      }
      List<AddToCart> obj=carteService.getCartByUserId(Long.parseLong( getCartRequest.get("userId")));
      //chneya el parsLong
      return ResponseEntity.ok(obj);//hedhi zeda
    }catch(Exception e) {
      return ResponseEntity.badRequest().body("");
    }
  }

}
