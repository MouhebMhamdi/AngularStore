package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.DetailProduitRepository;
import tn.esprit.model.DetailProduit;

@Service
public class detailProduitImpl implements detailProduit{
    @Autowired
    DetailProduitRepository detailProduitRepository;
    @Override
    public void addDetailProduit(DetailProduit detailProduit) {
        if(!detailProduitRepository.findById(detailProduit.getIdDetailProduit()).isPresent()){
            detailProduitRepository.save(detailProduit);
        }else{
            System.out.println("Detail Produit existe déja !!");
        }
    }

    @Override
    public DetailProduit getDetailProduitById(long id) {
        return detailProduitRepository.findById(id).get();
    }
}
