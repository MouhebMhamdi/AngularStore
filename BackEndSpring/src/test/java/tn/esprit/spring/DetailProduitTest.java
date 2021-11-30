package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.CategorieProduit;
import tn.esprit.model.DetailProduit;
import tn.esprit.services.detailProduitImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class DetailProduitTest {

    @Autowired
    detailProduitImpl detailProduitService;

    @Test
    public void Test(){
        DetailProduit detailProduit=new DetailProduit();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        detailProduit.setDatDernieremodification(date);
        detailProduit.setDateCreation(date);
        detailProduit.setCategorieProduit(CategorieProduit.Alimentaire);
        detailProduitService.addDetailProduit(detailProduit);
    }
}
