package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.Rayon;
import tn.esprit.services.RayonServiceImp;

@SpringBootTest
public class RayonTest {


    @Autowired
    RayonServiceImp rayonServiceImp;

    @Test
    public void Test(){

        Rayon r=new Rayon();
        r.setCode("256266");
        r.setLibelle("Vetement");
        rayonServiceImp.addRayon(r);


    }
}
