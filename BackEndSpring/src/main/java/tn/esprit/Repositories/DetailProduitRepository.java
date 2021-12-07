package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.model.DetailProduit;
import tn.esprit.model.Produit;
import tn.esprit.model.CategorieProduit;

import java.util.Date;
import java.util.List;

@Repository
public interface DetailProduitRepository extends CrudRepository <DetailProduit,Long> {

    /**not yet**/
    @Query("SELECT dp.produit FROM DetailProduit dp WHERE dp.dateCreation  = :dateBefore")
    List<Produit> findByDateCreation(@Param("dateBefore") Date dateCreation);
    /**not yet**/
    @Query("SELECT dp.produit FROM DetailProduit dp WHERE dp.dateCreation between :startDate AND :endDate")
    List<Produit> findByDateCreationBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate );
    /**not yet**/
    @Query("SELECT dp.produit FROM DetailProduit dp WHERE dp.dateCreation  <= :dateBefore")
    List<Produit> findByDateCreationBefore( @Param("dateBefore") Date dateBefore);

    /**not yet**/
    @Query("SELECT dp.produit FROM DetailProduit dp WHERE dp.dateDerniereModification <= :derniereModification")
    List<Produit> findByDateDernieremodification(@Param("derniereModification") Date derniereModification);


}
