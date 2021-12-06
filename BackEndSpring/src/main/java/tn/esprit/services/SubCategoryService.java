package tn.esprit.services;

import tn.esprit.model.SubCategory;
import java.util.List;

public interface SubCategoryService {
    public List<SubCategory> retrieveAllSubCategories();
    public SubCategory addSubCategory(SubCategory subCategory);
    public SubCategory retrieveSubCategory(Long id);
    public void deleteSubCategory(Long id);
    public SubCategory updateSubCategory(SubCategory subCategory);
}
