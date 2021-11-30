package tn.esprit.spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.Fournisseur;
import tn.esprit.services.FournisseurServiceImpl;

@SpringBootTest
public class FournisseurTest {

    @Autowired
    FournisseurServiceImpl fournisseurService;

    @Test
    public void Test(){
        Fournisseur f=new Fournisseur();
        f.setCode("ha250");
        f.setLibelle("Vetment");
        f.setCode("123");
        f.setLibelle("samsung");

        fournisseurService.addFournisseur(f);

    }
}
