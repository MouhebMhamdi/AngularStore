package tn.esprit.spring;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.model.User;
import tn.esprit.services.UserServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
public class UserTest {

    @Autowired
    private UserServiceImpl clientServiceImpl;




    @Test
    public void test(){

        try {
            User user =new User();
            Date date= new SimpleDateFormat( "yyyyMMdd" ).parse( "20051105" );
            user.setEmail("7ARBOUCHA@gmail.com");
            user.setNom("RJAB");
            user.setPrenom("MONJI");
            user.setPassword("1234");


            user.setDateNaissance(date);
            clientServiceImpl.ajouterUser(user);


            // clientServiceImpl.supprimerClient(1);
        }catch (Exception e){


            System.out.println(e.getMessage());
        }




    }
}
