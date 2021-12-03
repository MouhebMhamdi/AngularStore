package tn.esprit.services;

import tn.esprit.model.DetailProduit;

import java.util.List;


public interface DetailProduitService {
	List<DetailProduit> retrieveAllDetailProduits();
	DetailProduit addDetailProduit(DetailProduit dp);
	void deleteDetailProduit(Long id);
	DetailProduit updateDetailProduit(DetailProduit dp);
	DetailProduit retrieveDetailProduit(Long id);



}
