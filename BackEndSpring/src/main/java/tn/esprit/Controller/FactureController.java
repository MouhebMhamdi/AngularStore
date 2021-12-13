package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Facture;
import tn.esprit.services.FactureServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/facture")
public class FactureController {

    @Autowired
    FactureServiceImpl factureService;

    @PostMapping("/addfacture")
    public String addfacture(@RequestBody Facture facture)
    {
        factureService.ajouterFacture(facture);
        return  "FACTURE AFJOUTER";
    }


    @DeleteMapping("/deletfacture/{id}")
    public String supprimerFacture(@PathVariable (value = "id")long id)
    {
        factureService.supprimerFacture(id);
        return "facture deleted";
    }

    @PutMapping("/updatefacture/{id}")
    public String updatefacture(@RequestBody Facture facture,@PathVariable  long id)
    {
        factureService.updatefacture(facture,id);
        return "facture has been updated !";
    }

    @GetMapping("/getfactureid/{id}")
    public Facture getFctureById(@PathVariable long id)
    {

   return      factureService.cherchefactureid(id);

    }

    @GetMapping("/getallfacture")
    public List<Facture> getAllFactur()
    {

        return   factureService.chercherFacture();

    }
}
