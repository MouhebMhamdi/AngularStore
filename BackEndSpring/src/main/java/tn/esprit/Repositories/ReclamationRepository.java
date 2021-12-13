package tn.esprit.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long>{

}
