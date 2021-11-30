package tn.esprit.services;

import tn.esprit.model.DetailFacture;

import java.util.List;


public interface DetailFactureService {
    void AddDetailFacture(DetailFacture detailFacture);
    void supprimerDetailFacture(long id);
    void updatedetailfacture(DetailFacture detf,long id);
    List<DetailFacture> chercherAllDetailFacture();

    DetailFacture getDetailFacture(long id);
}