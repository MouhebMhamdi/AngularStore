package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.model.CategorieClient;
import tn.esprit.model.Categories;

@Repository
public interface CategorieRepository extends JpaRepository<Categories,Long> {
  @Query("SELECT c FROM Categories c WHERE c.Name=:name")
  Categories getCategoriesByName(String name);
}
