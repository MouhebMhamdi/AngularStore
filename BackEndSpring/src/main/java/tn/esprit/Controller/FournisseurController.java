package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Fournisseur;
import tn.esprit.services.FournisseurServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurController {
	
	
	@Autowired
	private FournisseurServiceImpl F;
	
	public FournisseurController(FournisseurServiceImpl F) {
		this.F=F;
	}

	
	@GetMapping("/AllFournisseur")
	public List <Fournisseur> getAllFournisseur(){
		return F.getAllFournisseur();
	}
	
	@GetMapping("{id}")
	public Fournisseur findById(@PathVariable long id) {
		return F.getFournisseurById(id);
	}
	
	@PostMapping("/AddFournisseur")
	public String AddFournisseur(@RequestBody Fournisseur fournisseur) {
		F.addFournisseur(fournisseur);
		return "Fournisseur add successfully!!";
	}
	
	@PostMapping("/DeleteFournisseur/{id}")
	public String DeleteFournisseur(@PathVariable long id) {
		F.DeleteFournisseur(id);
		return "Fournisseur Deleted successfully !!";
	}
	
    @PostMapping("/updateFournisseur/{id}")
    public String UpdateUser(@RequestBody Fournisseur fournisseur, @PathVariable long id){
    
        F.updateFournisseur(fournisseur,id);
        return "Fournisseur updated successfuly Don !!";
    }
    
    @PostMapping("/DeleteAllFournisseur")
    public String DeleteAllFournisseur() {
    	F.DeleteAllFournisseur();
    	return "All Fournisseur are deleted successfully !!";
    }
}
