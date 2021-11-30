package tn.esprit.services;

import tn.esprit.model.DetailProduit;

public interface detailProduit {
    void addDetailProduit(DetailProduit detailProduit);
    DetailProduit getDetailProduitById(long id);
}
