package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.DetailFactureRepository;
import tn.esprit.model.DetailFacture;

import java.util.List;

@Service
public class DetailFactureImpl implements DetailFactureService{

    @Autowired
    DetailFactureRepository detailFactureRepository;


    @Override
    public void AddDetailFacture(DetailFacture detailFacture) {
        if(!detailFactureRepository.findById(detailFacture.getIdDetailFacture()).isPresent()){
            detailFactureRepository.save(detailFacture);
        }else{
            System.out.println("Detail Facture Existe déja !!");
        }
    }

    @Override
    public void supprimerDetailFacture(long id) {
        detailFactureRepository.deleteById(id);
    }

    @Override
    public void updatedetailfacture(DetailFacture detf,long id) {
        DetailFacture f=detailFactureRepository.findById(id).get();
        if (f.getDateDernierModification()!=null){ f.setDateDernierModification(detf.getDateDernierModification()); }

        if(f.getDateCreation()!=null){f.setDateCreation(detf.getDateCreation());}
        detailFactureRepository.save(f);
    }

    @Override
    public List<DetailFacture> chercherAllDetailFacture() {
        return  detailFactureRepository.findAll();
    }


    @Override
    public DetailFacture getDetailFacture(long id) {
        return detailFactureRepository.findById(id).get();
    }
}
