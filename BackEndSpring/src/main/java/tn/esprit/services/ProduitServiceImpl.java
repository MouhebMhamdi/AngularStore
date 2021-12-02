package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.model.Categories;
import tn.esprit.model.Produit;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    stockService stockService;
    @Override
    public void addProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public Produit getProduitById(long id) {
        return  produitRepository.findById(id).get();
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit prod=produitRepository.getById(idProduit);
        prod.setStock(stockService.getStockById(idStock));
        produitRepository.save(prod);
    }

  @Override
  public void setCategorieToProduit(Categories categories, long idProduit) {
    Produit p=produitRepository.findById(idProduit).get();
    p.setCategories(categories);
    produitRepository.save(p);

  }


}
