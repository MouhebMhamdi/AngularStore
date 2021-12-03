package tn.esprit.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.FourniseurRepository;
import tn.esprit.model.Fournisseur;
import tn.esprit.model.Produit;

@Service
public class FournisseurServiceImpl implements FournisseurService{
    @Autowired
    FourniseurRepository fourniseurRepository;

    @Autowired
    ProduitServiceImpl produitService;
    @Override
    public void addFournisseur(Fournisseur fournisseur) {
        if(!fourniseurRepository.findById(fournisseur.getIdFournisseur()).isPresent()){
            fourniseurRepository.save(fournisseur);
        }else{
            System.out.println("Fournisseur existe déja");
        }
    }

    @Override
    public Fournisseur getFournisseurById(long id) {
        return fourniseurRepository.findById(id).get();
    }
    @Override
    public List<Fournisseur> getAllFournisseur() {
    	return fourniseurRepository.findAll();
    }

    @Override
    public void DeleteFournisseur(long id) {
    	fourniseurRepository.deleteById(id);
    }

    @Override
    public void updateFournisseur(Fournisseur fournisseur, long id) {

    	Fournisseur F1=fourniseurRepository.findById(id).get();

        if(fournisseur.getCode()!=null)F1.setCode(fournisseur.getCode());
        if(fournisseur.getLibelle()!=null)F1.setLibelle(fournisseur.getLibelle());

        fourniseurRepository.save(fournisseur);
    }

    @Override
    public void DeleteAllFournisseur() {
    	fourniseurRepository.deleteAll();
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {

        Fournisseur four=fourniseurRepository.findById(fournisseurId).get();
        Set<Fournisseur> f=new HashSet<>();
        f.add(four);
        Produit p= produitService.retrieveProduit(produitId);
        p.setFournisseurs(f);

    //    produitService.addProduit(p);


    }


}
