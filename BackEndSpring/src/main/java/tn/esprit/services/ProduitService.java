package tn.esprit.services;


import tn.esprit.model.Categories;
import tn.esprit.model.Produit;

public interface ProduitService {
    public void addProduit(Produit produit);
    public Produit getProduitById(long id);
    void assignProduitToStock(Long idProduit, Long idStock);
    void setCategorieToProduit(Categories categories, long idProduit);


}
