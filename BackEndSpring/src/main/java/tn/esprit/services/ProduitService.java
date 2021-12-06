package tn.esprit.services;


import tn.esprit.model.Produit;
import java.util.List;

public interface ProduitService {
  List<Produit> retrieveAllProduits();
  Produit addProduit(Produit p, Long idStock, Long idRayon);
  Produit retrieveProduit(Long id);
  void deleteProduit(Long id);
  Produit updateProduit(Produit p);

}
