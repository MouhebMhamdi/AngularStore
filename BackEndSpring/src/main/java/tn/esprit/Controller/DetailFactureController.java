package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.DetailFacture;
import tn.esprit.model.Facture;
import tn.esprit.services.DetailFactureImpl;

import java.util.List;

@RestController
@RequestMapping("/api/detailfacture")

public class DetailFactureController {
@Autowired
    DetailFactureImpl df;

//mochkla fel add tji NULL
    @PostMapping("adddetailfacture")
    public String adddetailfact(@RequestBody DetailFacture dfacture)
    {
       df.AddDetailFacture(dfacture); ;
        return  "DETAIL FACTURE AFJOUTER";
    }

    @GetMapping("/deletDetailfacture/{id}")
    public String supprimerDetailFacture(@PathVariable (value = "id")long id)
    {
        df.supprimerDetailFacture(id);
        return "detail facture deleted";
    }


    @GetMapping("getallDetailsfacture")
    public List<DetailFacture> getAllDetails()
    {

    return df.chercherAllDetailFacture();

    }
    @GetMapping("/updatedetailfacture/{id}")
    public String updatefacture(@RequestBody DetailFacture detf,@PathVariable long id)
    {
        df.updatedetailfacture(detf,id);
        return "";
    }
}
