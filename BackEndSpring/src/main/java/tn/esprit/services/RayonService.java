package tn.esprit.services;



import java.util.List;

import tn.esprit.model.Rayon;

public interface RayonService {
    public void addRayon(Rayon rayon);
    public Rayon getRayonById(long id);
    public List<Rayon> getAllRayon();
    public void DeleteRayon(long id);
    public void DeleteAllRayon();
    public void UpdateRayon(Rayon rayon, long id);
    void assignProduitToStock(Long idProduit, Long idStock);
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
