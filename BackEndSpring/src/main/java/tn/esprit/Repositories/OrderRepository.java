package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.CheckOutCart;

@Repository
public interface OrderRepository extends JpaRepository<CheckOutCart,Long> {
}
