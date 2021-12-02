package tn.esprit.Controller;

import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.JWTConfiguration.ShoppingConfiguration;
import tn.esprit.model.AddToCart;
import tn.esprit.services.CartService;
import tn.esprit.services.CarteServiceImpl;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/addtocart")
public class AddToCartController {

  @Autowired
CarteServiceImpl carteService;



  /*@RequestMapping("addproduct")
  public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
    try {
      String keys[] = {"productId","userId","qty","price"};
      if(ShoppingConfiguration.validationwithHashmap(keys, addCartRequest)) {

      }
      long productId = Long.parseLong(addCartRequest.get("productId"));
      long userId =  Long.parseLong(addCartRequest.get("userId"));
      int qty =  Integer.parseInt(addCartRequest.get("qty"));
      double price = Double.parseDouble(addCartRequest.get("price"));
     // List<AddToCart> obj = carteService.addCartByUserAndProductId(productId,userId,qty);
      return ResponseEntity.ok(obj);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
    }

  }*/

  /*@RequestMapping("removeproductfromcart")
  public ResponseEntity<?>RemoveCartWithProductId(@RequestBody HashMap<String,String> removeCartRequest){
   removeCartRequest.get("");

  }
*/
 /* @RequestMapping("getcartbyuserid")
  public ResponseEntity<?>getCartByUserId(@RequestBody HashMap<String,String> getCartRequest){
    getCartRequest.get("");

  }*/

}
