package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Repositories.FourniseurRepository;
import tn.esprit.model.*;
import tn.esprit.services.*;

import java.util.HashSet;
import java.util.Set;



@RestController
public class ProduitController {
@Autowired
ProduitServiceImpl ProduitController;
@Autowired
FourniseurRepository fourniseurRepository;

@Autowired
ProduitServiceImpl produitService;

@Autowired
detailProduitImpl detailProduitService;



@Autowired
RayonServiceImp rayonServiceImp;

@Autowired
DetailFactureImpl detailFactureImpl;


@Autowired
StockServiceImpl stockServiceImpl;

@Autowired
FournisseurServiceImpl fournisseurService;

@GetMapping("/get/{id}")
public Produit getproduitController(@PathVariable long id) {
	return ProduitController.getProduitById(id);
	
}

@PostMapping("/save")
 public void addProduit(@RequestBody  Produit produit) {
	 Set<Fournisseur> f = new HashSet<Fournisseur>();
	for (Fournisseur fourni:produit.getFournisseurProduit()) {
		Fournisseur fournisseur=fourniseurRepository.findById(fourni.getIdFournisseur()).get();
		f.add(fournisseur);
	}
	//Fournisseur fournisseur=fourniseurRepository.findById(produit.getFournisseurProduit().).get();
    //Set<Fournisseur> f = new HashSet<Fournisseur>();
    //f.add(fournisseur);
	
	
    Stock s=stockServiceImpl.getStockById(produit.getStock().getIdStock());
    Rayon r=rayonServiceImp.getRayonById(produit.getRayon().getIdRayon());
    DetailFacture d=detailFactureImpl.getDetailFacture(produit.getDetailFacture().getIdDetailFacture());
    DetailProduit detailProduit=detailProduitService.getDetailProduitById(produit.getDetailProduit().getIdDetailProduit());
	Produit p=new Produit();
	p.setIdprixUnitaire(produit.getIdprixUnitaire());
    p.setCode(produit.getCode());
    p.setIdlibelle(produit.getIdlibelle());
    
    p.setRayon(r);
    p.setDetailProduit(detailProduit);
    p.setDetailFacture(d);
    p.setStock(s);
    p.setFournisseurProduit(f);
    
    ProduitController.addProduit(p);
	
}
	
	


	









}
