package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Repositories.FourniseurRepository;
import tn.esprit.model.*;
import tn.esprit.services.*;

import java.util.HashSet;
import java.util.Set;



@RestController
@RequestMapping("/api/produit")
public class ProduitController {
@Autowired
ProduitServiceImpl  produitService;

@Autowired
RayonServiceImp rayonServiceImp;

@Autowired
StockServiceImpl stockService;
@GetMapping("/getProductById/{id}")
public Produit getproduitController(@PathVariable long id) {
	return produitService.getProduitById(id);

}

@PostMapping("/addProduct")
 public void addProduit(@RequestBody  Produit produit) {
  produitService.addProduit(produit);
}


@PostMapping("/addRayonToProduit")
  public void addRayonToProduit(@RequestBody Rayon rayon,@RequestParam long idProduct){
  Produit produit=produitService.getProduitById(idProduct);

  rayonServiceImp.addRayon(rayon);

  produit.setRayon(rayon);
  produitService.addProduit(produit);
}


@PostMapping("/addStockToProduct")
  public  void addStockToProduct(@RequestBody Stock stock,@RequestParam long idProduct){
  Produit produit=produitService.getProduitById(idProduct);
  produit.setStock(stock);
  stockService.addStock(stock);
  produitService.addProduit(produit);
}














}
