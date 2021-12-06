package tn.esprit.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.model.Category;
import tn.esprit.services.CategoryServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/category")
@Api(tags = "Gestion des Categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;


    @ApiOperation(value = "Récupérer la liste des categories")
    @GetMapping("/getAllCategories")
    @ResponseBody
    public List<Category> getAllCategories() {
        List<Category> listCategories = categoryService.retrieveAllCategories();
        return listCategories;
    }

    @ApiOperation(value = "Récupérer une Categorie par id")
    @GetMapping("/getCategory/{id}")
    @ResponseBody
    public Category getCategory(@PathVariable(value = "id") long id) {
        return categoryService.retrieveCategory(id);
    }


    @ApiOperation(value = "Ajouter une Categorie")
    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category c) {
        Category category = categoryService.addCategory(c);
        return category;
    }


    @ApiOperation(value = "Supprimer une Categorie par id")
    @DeleteMapping("/deleteCategory/{id}")
    @ResponseBody
    public void deleteCategory(@PathVariable(value = "id") long id) {
        categoryService.deleteCategory(id);
    }

    @ApiOperation(value = "Modifier une Categorie")
    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category);
        return getCategory(category.getIdCategory());
    }

}
