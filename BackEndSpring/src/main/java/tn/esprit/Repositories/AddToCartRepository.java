package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.model.AddToCart;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart,Long> {

  //add by product with user Id
  //remove carte by user ID
  //getCart by user id

  @Query("Select addCart  FROM AddToCart addCart WHERE addCart.user_id=:user_id")
  List<AddToCart> getCartByuserId(@Param("user_id")Long user_id);

  @Query("Select addCart  FROM AddToCart addCart WHERE addCart.produit.idProduit= :product_id and addCart.user_id=:user_id")
  Optional<AddToCart> getCartByProductIdAnduserId(@Param("user_id")Long user_id, @Param("product_id")Long product_id);

  @Modifying
  @Transactional
  @Query("DELETE  FROM AddToCart addCart WHERE addCart.id =:cart_id   and addCart.user_id=:user_id")
  void deleteCartByIdAndUserId(@Param("user_id")Long user_id,@Param("cart_id")Long cart_id);


  @Modifying
  @Transactional
  @Query("update AddToCart addCart set addCart.qty=:qty,addCart.price=:price WHERE addCart.id=:cart_id")
  void updateQtyByCartId(@Param("cart_id")Long cart_id,@Param("price")double price,@Param("qty")Integer qty);



  @Query("Select sum (addCart.price)   FROM AddToCart addCart WHERE addCart.user_id=:user_id")
  double getTotalAmountByUserId(@Param("user_id")Long user_id);



  @Modifying
  @Transactional
  @Query("DELETE  FROM AddToCart addCart WHERE   addCart.user_id=:user_id")
  void deleteAllCartByUserId(@Param("user_id")Long user_id);
}
