package tn.esprit.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.SubCategory;
import tn.esprit.services.SubCategoryServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/subCategory")
@Api(tags = "Gestion des Sous Categories")
public class SubCategoryController {

    @Autowired
    private SubCategoryServiceImpl subCategoryService;


    @ApiOperation(value = "Récupérer la liste des Sous Categories")
    @GetMapping("/getAllSubCategories")
    @ResponseBody
    public List<SubCategory> getAllSubCategories() {
        List<SubCategory> listSubCategories = subCategoryService.retrieveAllSubCategories();
        return listSubCategories ;
    }


    @ApiOperation(value = "Récupérer une Sous Categorie par id")
    @GetMapping("/getSubCategory/{id}")
    @ResponseBody
    public SubCategory getSubCategory(@PathVariable(value = "id") long id) {
        return subCategoryService.retrieveSubCategory(id);
    }


    @ApiOperation(value = "Ajouter une Sous Categorie")
    @PostMapping("/addSubCategory")
    public SubCategory addSubCategory(@RequestBody SubCategory s) {
        SubCategory subCategory = subCategoryService.addSubCategory(s);
        return subCategory;
    }


    @ApiOperation(value = "Supprimer une Sous Categorie par id")
    @DeleteMapping("/deleteSubCategory/{id}")
    @ResponseBody
    public void deleteSubCategory(@PathVariable(value = "id") long id) {
        subCategoryService.deleteSubCategory(id);
    }

    @ApiOperation(value = "Modifier une Sous Categorie")
    @PutMapping("/updateSubCategory")
    public SubCategory updateSubCategory(@RequestBody SubCategory subCategory) {
        subCategoryService.updateSubCategory(subCategory);
        return getSubCategory(subCategory.getIdSubCategory());
    }

}
