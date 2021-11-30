package tn.esprit.services;



import tn.esprit.model.Facture;

import java.util.List;

public interface FactureService {
    void ajouterFacture(Facture factures);
    void supprimerFacture(long id);
    void supprimerToutLesFactures();
    List<Facture> chercherFacture();
     Facture cherchefactureid(Long id);
    void updatefacture(Facture facture,Long id);


    List<Facture> getFacturesByClient(Long idClient);

    Facture addFacture(Facture f, Long idClient);

}
