package tn.esprit.spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.Repositories.FourniseurRepository;
import tn.esprit.model.*;
import tn.esprit.services.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class ProduitTest {
  @Autowired
  StockServiceImpl ss;
  @Autowired
  ProduitServiceImpl ps;
  @Autowired
  RayonServiceImp rs;
  @Autowired
  DetailFactureImpl df;



  @Test
  void contextLoads() throws ParseException {

    System.out.println("**************");



    Stock stock=ss.getStockById(1l);
    Rayon rayon=rs.getRayonById(1l);

    Date date= new SimpleDateFormat( "yyyyMMdd" ).parse( "19980112" );
    DetailProduit dp= new DetailProduit();
    dp.setDateCreation(date);
    dp.setDateDerniereModification(date);
   // dp.setCategorieProduit(CategorieProduit.Elecromenager);

    Produit p=new Produit();
    p.setCode("123");
    p.setLibelle("saba");
    p.setPrixUnitaire(0.1f);
    //  ps.addProduit(p,stock.getIdStock(), rayon.getIdRayon());
    //  Produit produitUpdate= new Produit();
    // produitUpdate.setLibelle("aaaaaa");
    //  produitUpdate.setPrixUnitaire(12);
    // ps.updateProduit(produitUpdate,57l);
    //  ps.deleteProduit(57l);
    System.out.println("Test Passed !!!!");



  }
}
