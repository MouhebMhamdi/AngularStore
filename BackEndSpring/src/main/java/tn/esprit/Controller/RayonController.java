package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Rayon;
import tn.esprit.services.RayonServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/Rayon")
public class RayonController {

	@Autowired
	RayonServiceImp R;
	
	public RayonController(RayonServiceImp R) {
		this.R=R;
	}
	
	@PostMapping("/AddRayon")
	public String AddRayon(Rayon rayon){
		R.addRayon(rayon);
		return("Rayon add don !!");
	}
	
	@DeleteMapping("/DeleteRayon/{id}")
	public String DeleteRayonByID (@PathVariable long id) {
		R.DeleteRayon(id);
		String s;
		s="Rayon " + id + " is deleted successfully";
		return s; 
	}
	
	@DeleteMapping("/DeleteAllRayon")
	public String DeleteAllRayon() {
		R.DeleteAllRayon();
		return "All Rayon are deleted successfully !!";
	}
	
	@GetMapping("{id}")
	public Rayon FindRayonByID(@PathVariable long id) {
		return R.getRayonById(id);
		
	}
	
	@GetMapping("/AllRayon")
	public List<Rayon> FindAllRayon() {
		return R.getAllRayon();
	}
	
	@PutMapping("/updateRayon/{id}")
	public void updaterayon(@RequestBody Rayon Rayon,@PathVariable long id) {
		R.UpdateRayon(Rayon,id);
	}
	
	@PutMapping("/assignProduitToStock")
	public void assignProduitToStock(Long idProduit, Long idStock) {
		R.assignProduitToStock(idProduit, idStock);
	}
	
	@PutMapping("/assignFournisseurToProduit")
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		R.assignFournisseurToProduit(fournisseurId, produitId);
	}
}
