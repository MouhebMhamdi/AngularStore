package tn.esprit.Controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.model.Produit;
import tn.esprit.model.User;
import tn.esprit.services.ProduitServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/produit")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags = "Gestion de Produit")
public class ProduitController {

  @Autowired
  private ProduitServiceImpl produitService;

  @ApiOperation(value = "Récupérer la liste des produits")
  @GetMapping("/getAllProduits")
  @ResponseBody
  public List<Produit> getAllProduits(){
    List<Produit> listProduit=produitService.retrieveAllProduits();
    return listProduit;
  }


  @ApiOperation(value = "Récupérer un Produit  par id")
  @GetMapping("/getProduit/{id}")
  @ResponseBody
  public Produit getProduit(@PathVariable(value="id") long id){
    return  produitService.retrieveProduit(id);
  }
  public String folderPath = "C:\\Users\\Mouheb\\Documents\\SpringAngular\\AngularStore\\src\\assets\\img\\" ;
  public String getFolderPath2="C:\\Users\\Mouheb\\Desktop\\dashboardAdmin\\src\\assets\\";

  @ApiOperation(value = "Ajouter un Produit")
  @PostMapping("/addProduit/{idStock}/{idRayon}")
  public Produit addProduit(@RequestBody Produit p,@PathVariable(value="idStock") long idStock,@PathVariable(value="idRayon") long idRayon){
    Produit produit=produitService.addProduit(p,idStock,idRayon);
    return produit;
  }
  @RequestMapping(value = "addImgTopr/{id}",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Object> AddImageTopro(@RequestParam("file") MultipartFile file,@PathVariable long id)throws IOException{
    int random =  (int) 	(Math.random() * ((100000000 - 10) + 1))  ;
    File convertFile = new File(folderPath+random+file.getOriginalFilename());
    convertFile.createNewFile();
    FileOutputStream fout = new FileOutputStream(folderPath+random+file.getOriginalFilename());
    fout.write(file.getBytes());
    fout.close();
    FileOutputStream fout2 = new FileOutputStream(getFolderPath2+random+file.getOriginalFilename());
    fout2.write(file.getBytes());
    fout2.close();

    Produit P=produitService.getproduitByid(id);
    P.setDocName(random+file.getOriginalFilename());
    P.setDocType(file.getContentType());
    produitService.addProduit(P,id,id);
    return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
  }
  @GetMapping("/getproduitByid/{id}")
  public Produit getproduitByid(@PathVariable(value = "id") long  id){
      return produitService.getproduitByid(id);
  }

  @ApiOperation(value = "Supprimer un Produit par id")
  @DeleteMapping("/deleteProduit/{id}")
  @ResponseBody
  public void deleteProduit(@PathVariable(value="id") long id){
    produitService.deleteProduit(id);
  }

  @ApiOperation(value = "Modifier un Produit")
  @PutMapping("/updateProduit")
  public Produit updateProduit(@RequestBody Produit produit){
    produitService.updateProduit(produit);
    return getProduit(produit.getIdProduit());
  }

}
