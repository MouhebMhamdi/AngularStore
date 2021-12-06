package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
  /*@Query("SELECT c FROM Categories c WHERE c.Name=:name")
  Categories getCategoriesByName(String name);*/
}
