package tn.esprit.spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.Facture;

import tn.esprit.services.FactureServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
public class FactureTest {
    @Autowired
    private FactureServiceImpl factureService;



    @Test
    public void test() {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());


        Facture facture=new Facture();
        facture.setDateFacture(date);
        facture.setMontantRemise(250);

        facture.setActive(true);
       factureService.ajouterFacture(facture);

    }
    }

