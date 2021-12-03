package tn.esprit.services;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.ProduitRepository;
import tn.esprit.model.DetailProduit;
import tn.esprit.model.Produit;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProduitServiceImpl implements ProduitService{

  DetailProduitServiceImpl detailProduitService;
  StockServiceImpl stockService;
  RayonServiceImp rayonService;
  ProduitRepository produitRepository;

  public ProduitServiceImpl(ProduitRepository produitRepository) {
    this.produitRepository = produitRepository;
  }


  /**Crud Service**/
  @Override
  public List<Produit> retrieveAllProduits() {
    List<Produit> produits = new ArrayList<>();
    produitRepository.findAll().forEach(e -> produits.add(e));
    for(Produit produit:produits){
      log.info("produit:"+produit);
    }
    return produits;
  }


  @SneakyThrows
  @Override
  public Produit retrieveProduit(Long id) {
    return produitRepository.findById(id).orElseThrow(() -> new NotFoundException("Produit not found"));
  }

  /**works**/
  @Override
  public Produit addProduit(Produit produit, Long idStock, Long idRayon) {
    produit.setRayon(rayonService.getRayonById(idRayon));
    produit.setStock(stockService.getStockById(idStock));
    DetailProduit detailProduit=new DetailProduit();
    produit.setDetailProduit(detailProduit);
    detailProduitService.addDetailProduit(detailProduit);
    produitRepository.save(produit);
    return produit;
  }


  @Override
  public void deleteProduit(Long id) {
    if(produitRepository.findById(id).isPresent()){
      produitRepository.deleteById(id);
    }
    else {
      System.out.println("No product with id "+id+" exists !!!");

    }
  }

  @Override
  public Produit updateProduit(Produit produit) {
    produitRepository.save(produit);
    return produit;
  }


}
