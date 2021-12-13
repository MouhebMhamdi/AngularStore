package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.FactureRepository;
import tn.esprit.model.Facture;
import tn.esprit.model.Rayon;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    private FactureRepository factureRepository;



    @Override
    public void ajouterFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public void supprimerFacture(long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public void supprimerToutLesFactures() {
        factureRepository.deleteAll();
    }

    @Override
    public List<Facture> chercherFacture() {
        return factureRepository.findAll();
    }

    @Override
    public Facture cherchefactureid(Long id) {
        return factureRepository.findById(id).get();
    }

    @Override
    public void updatefacture(Facture facture, Long id) {
      Facture facture1 = factureRepository.findById(id).get();
      if(facture.getDateFacture()!=null) facture1.setDateFacture(facture.getDateFacture());
      if(facture.getMontantFacture()!=0) facture1.setMontantFacture(facture.getMontantFacture());
      if(facture.getMontantRemise()!=0) facture1.setMontantRemise(facture.getMontantRemise());
      if(facture.getMontantFacture()!=0) facture1.setMontantFacture(facture.getMontantFacture());
      if(facture.getEtat()!=null) facture1.setEtat(facture.getEtat());
factureRepository.save(facture1);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        return null;
    }

    @Override
    public Facture addFacture(Facture f, Long idClient) {
        return null;
    }
}
