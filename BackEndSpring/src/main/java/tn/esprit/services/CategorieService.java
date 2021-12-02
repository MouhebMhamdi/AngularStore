package tn.esprit.services;

import tn.esprit.model.Categories;

import java.util.List;

public interface CategorieService {
List<Categories> getAllCategories();
Categories getCategorieByName(String name);
void addCategorie(String catName);
void deleteCategorieByName(String catName);
void deleteCategorieById(long id);
void updateCategorie(String newCatName ,long id);

}
