package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.CategorieProduit;
import tn.esprit.model.DetailFacture;
import tn.esprit.services.DetailFactureImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class DetailFactureTest {
    @Autowired
    DetailFactureImpl detailFactureImpl;

    @Test
    public void Test(){
        DetailFacture d=new DetailFacture();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        d.setCategorieProduit(CategorieProduit.Elecromenager);
        d.setDateCreation(date);
        d.setDateDernierModification(date);
        detailFactureImpl.AddDetailFacture(d);
    }
}
