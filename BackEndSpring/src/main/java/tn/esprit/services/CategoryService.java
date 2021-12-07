package tn.esprit.services;

import tn.esprit.model.Category;
import java.util.List;

public interface CategoryService {
  public List<Category> retrieveAllCategories();
  public Category addCategory(Category category);
  public Category retrieveCategory(Long id);
  public void deleteCategory(Long id);
  public Category updateCategory(Category category);

}
