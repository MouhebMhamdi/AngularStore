package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {

}
