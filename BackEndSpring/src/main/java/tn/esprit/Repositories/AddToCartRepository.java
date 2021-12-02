package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.model.AddToCart;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart,Long> {
  //add by product with user Id
  //remove carte by user ID
  //getCart by user id

  @Query("Select addCart  FROM AddToCart addCart WHERE addCart.user_id=:user_id")
  List<AddToCart> getCartByuserId(@Param("user_id")Long user_id);

}
