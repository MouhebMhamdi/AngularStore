package tn.esprit.Controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Produit;
import tn.esprit.services.ProduitServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = "Gestion de Produit")
public class ProduitController {

  @Autowired
  private ProduitServiceImpl produitService;

  @ApiOperation(value = "Récupérer la liste des produits")
  @GetMapping("/getAllProduits")
  @ResponseBody
  public List<Produit> getAllProduits(){
    List<Produit> listProduit=produitService.retrieveAllProduits();
    return listProduit;
  }


  @ApiOperation(value = "Récupérer un Produit  par id")
  @GetMapping("/getProduit/{id}")
  @ResponseBody
  public Produit getProduit(@PathVariable(value="id") long id){
    return  produitService.retrieveProduit(id);
  }


  @ApiOperation(value = "Ajouter un Produit")
  @PostMapping("/addProduit/{idStock}/{idRayon}")
  public Produit addProduit(@RequestBody Produit p,@PathVariable(value="idStock") long idStock,@PathVariable(value="idRayon") long idRayon){
    Produit produit=produitService.addProduit(p,idStock,idRayon);
    return produit;
  }


  @ApiOperation(value = "Supprimer un Produit par id")
  @DeleteMapping("/deleteProduit/{id}")
  @ResponseBody
  public void deleteProduit(@PathVariable(value="id") long id){
    produitService.deleteProduit(id);
  }

  @ApiOperation(value = "Modifier un Produit")
  @PutMapping("/updateProduit")
  public Produit updateProduit(@RequestBody Produit produit){
    produitService.updateProduit(produit);
    return getProduit(produit.getIdProduit());
  }

}
