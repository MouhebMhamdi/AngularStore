package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.model.DetailFacture;

public interface DetailFactureRepository extends JpaRepository<DetailFacture,Long> {
}
