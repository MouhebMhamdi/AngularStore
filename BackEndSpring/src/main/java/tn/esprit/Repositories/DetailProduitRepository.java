package tn.esprit.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.DetailProduit;

@Repository
public interface DetailProduitRepository  extends JpaRepository<DetailProduit,Long> {
}
