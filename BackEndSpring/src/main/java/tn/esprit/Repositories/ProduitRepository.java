package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.model.Produit;

    public interface ProduitRepository  extends JpaRepository<Produit,Long> {



}
