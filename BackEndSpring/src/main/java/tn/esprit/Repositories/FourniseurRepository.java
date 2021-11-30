package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Fournisseur;

@Repository
public interface FourniseurRepository extends JpaRepository<Fournisseur,Long> {
    @Query("select f from Fournisseur f where f.code= :code")
    Fournisseur getFournisseurByCode(String code);
}
