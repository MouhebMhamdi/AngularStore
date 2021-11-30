package tn.esprit.services;

import java.util.List;

import tn.esprit.model.Fournisseur;

public interface FournisseurService {
    public void addFournisseur(Fournisseur fournisseur);
    public Fournisseur getFournisseurById(long id);
    public List<Fournisseur> getAllFournisseur();
    public void DeleteFournisseur(long id);
    public void updateFournisseur(Fournisseur fournisseur, long id);
    public void DeleteAllFournisseur();
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;



}
