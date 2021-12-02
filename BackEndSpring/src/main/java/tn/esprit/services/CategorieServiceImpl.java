package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.CategorieRepository;
import tn.esprit.model.Categories;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService{
  @Autowired
  private CategorieRepository categorieRepository;

  @Override
  public List<Categories> getAllCategories() {
    return categorieRepository.findAll();
  }

  @Override
  public Categories getCategorieByName(String name) {
    return categorieRepository.getCategoriesByName(name);
  }

  @Override
  public void addCategorie(String catName) {

    categorieRepository.save(new Categories(catName));
  }

  @Override
  public void deleteCategorieByName(String catName) {
    categorieRepository.delete(categorieRepository.getCategoriesByName(catName));
  }

  @Override
  public void deleteCategorieById(long id) {
      categorieRepository.delete(categorieRepository.findById(id).get());

  }

  @Override
  public void updateCategorie(String newCatName, long id) {
      Categories categories=categorieRepository.findById(id).get();
      categories.setName(newCatName);
      categorieRepository.save(categories);
  }
}
