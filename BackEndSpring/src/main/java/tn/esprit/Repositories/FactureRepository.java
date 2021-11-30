package tn.esprit.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Facture;
import tn.esprit.model.User;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {

    @Query("SELECT f FROM Facture f,User u WHERE f.user.idClient=u.idClient AND f.user.idClient=:idClient")
    List<Facture> getFactureByClient(long idClient);


}
