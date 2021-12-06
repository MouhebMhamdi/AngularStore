package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.SubCategoryRepository;
import tn.esprit.model.SubCategory;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public List<SubCategory> retrieveAllSubCategories() {
        List<SubCategory> subCategories= new ArrayList<>();
        subCategoryRepository.findAll().forEach(e -> subCategories.add(e));
        for(SubCategory subCategory :subCategories){
            log.info("product sub category:"+ subCategory);
        }
        return subCategories;
    }

    @Override
    public SubCategory addSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory retrieveSubCategory(Long id) {
        return subCategoryRepository.findById(id).get();
    }

    @Override
    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);

    }

    @Override
    public SubCategory updateSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }
}
