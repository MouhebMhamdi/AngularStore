package tn.esprit.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Reclamation;
import tn.esprit.services.ReclamationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/reclamation")
@Api(tags = "Gestion de Reclamation")
public class ReclamationController {

  @Autowired
  private ReclamationServiceImpl reclamationService;

  /**works**/
  @ApiOperation(value = "Récupérer la liste des Réclamations")
  @GetMapping("/getAllReclamations")
  @ResponseBody
  public List<Reclamation> getAllReclamations(){
    List<Reclamation> listReclamations=reclamationService.retrieveAllReclamations();
    return listReclamations;
  }

  /**works**/
  @ApiOperation(value = "Récupérer une Réclamation par id")
  @GetMapping("/getReclamation/{id}")
  @ResponseBody
  public Reclamation getReclamation(@PathVariable(value="id") long id){
    return  reclamationService.retrieveReclamation(id);
  }

  @ApiOperation(value = "Ajouter une Réclamation ")
  @PostMapping("/addReclamation")
  public Reclamation addReclamation(@RequestBody Reclamation r){
    Reclamation reclamation=reclamationService.addReclamation(r);
    return reclamation;
  }

  /**works**/
  @ApiOperation(value = "Supprimer une Réclamation par id")
  @DeleteMapping("/deleteReclamation/{id}")
  @ResponseBody
  public void deleteReclamation(@PathVariable(value="id") long id){
    reclamationService.deleteReclamation(id);
  }

  /**works**/
  @ApiOperation(value = "Modifier une Réclamation ")
  @PutMapping("/updateReclamation")
  public Reclamation updateReclamation(@RequestBody Reclamation reclamation){
    reclamationService.updateReclamation(reclamation);
    return getReclamation(reclamation.getIdReclamation());
  }


}
