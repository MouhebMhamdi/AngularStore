package tn.esprit.services;

import tn.esprit.model.Reclamation;

import java.util.List;

public interface ReclamationService {
  List<Reclamation> retrieveAllReclamations();
  Reclamation retrieveReclamation(Long id);
  Reclamation addReclamation(Reclamation rec);
  Reclamation updateReclamation(Reclamation rec);
  void deleteReclamation(Long id);

}
