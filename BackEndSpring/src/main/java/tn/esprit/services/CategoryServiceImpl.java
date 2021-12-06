package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.CategoryRepository;
import tn.esprit.model.Category;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  public List<Category> retrieveAllCategories() {
    List<Category> categories= new ArrayList<>();
    categoryRepository.findAll().forEach(e -> categories.add(e));
    for(Category category :categories){
      log.info("product category:"+ category);
    }
    return categories;
  }

  @Override
  public Category addCategory(Category category) {
    categoryRepository.save(category);
    return category;
  }

  @Override
  public Category retrieveCategory(Long id) {
    return categoryRepository.findById(id).get();
  }

  @Override
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
  public Category updateCategory(Category category) {
    return categoryRepository.save(category);
  }
}
