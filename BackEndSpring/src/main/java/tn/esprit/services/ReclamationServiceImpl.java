package tn.esprit.services;


import org.springframework.stereotype.Service;
import tn.esprit.Repositories.ReclamationRepository;
import tn.esprit.model.Reclamation;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReclamationServiceImpl implements ReclamationService{

  ReclamationRepository reclamationRepository;

  public ReclamationServiceImpl (ReclamationRepository reclamationRepository) {
    this.reclamationRepository = reclamationRepository;
  }


  @Override
  public List<Reclamation> retrieveAllReclamations() {
    List<Reclamation> list = new ArrayList<>();
    reclamationRepository.findAll().forEach(e -> list.add(e));
    return  list;
  }

  @Override
  public Reclamation retrieveReclamation(Long id) {
    return 	reclamationRepository.findById(id).get();

  }

  @Override
  public Reclamation addReclamation(Reclamation reclamation) {
    reclamationRepository.save(reclamation);
    return reclamation;
  }


  @Override
  public Reclamation updateReclamation(Reclamation reclamation) {
    reclamationRepository.save(reclamation);
    return reclamation ;
  }

  @Override
  public void deleteReclamation(Long id) {
    if(reclamationRepository.findById(id).isPresent()){
      reclamationRepository.deleteById(id);
    }
    else {
      System.out.println("No reclamation with id "+id+" exists !!!");
    }

  }


}
