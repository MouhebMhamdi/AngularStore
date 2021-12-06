package tn.esprit.services;

import javassist.NotFoundException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.model.CategorieProduit;
import tn.esprit.model.DetailProduit;
import tn.esprit.model.Produit;
import tn.esprit.Repositories.DetailProduitRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
public class DetailProduitServiceImpl implements DetailProduitService{

	DetailProduitRepository detailProduitRepository;

	    public DetailProduitServiceImpl(DetailProduitRepository detailProduitRepository) {
	        this.detailProduitRepository = detailProduitRepository;
	    }


	@Override
	public List<DetailProduit> retrieveAllDetailProduits() {
		List<DetailProduit> detailProduits = new ArrayList<>();
		detailProduitRepository.findAll().forEach(e -> detailProduits.add(e));
		for(DetailProduit detailProduit:detailProduits){
			log.info("detailProduit:"+detailProduit);
		}
		return detailProduits;
	}



	@Override
	public DetailProduit addDetailProduit(DetailProduit detailProduit) {
	    	detailProduitRepository.save(detailProduit);
	     return detailProduit;
		}

	@Override
	public void deleteDetailProduit(Long id) {
		if(detailProduitRepository.findById(id).isPresent()){
			detailProduitRepository.deleteById(id);
		}
		else {
			System.out.println("No detailProduit with id "+id+" exists !!!");
		}
	}


	@SneakyThrows
	@Override
	public DetailProduit retrieveDetailProduit(Long id) {
		return detailProduitRepository.findById(id).orElseThrow(() -> new NotFoundException("DetailProduit"));

	}


	@Override
	public DetailProduit updateDetailProduit(DetailProduit detailProduit) {
	        detailProduitRepository.save(detailProduit);
	       return detailProduit;
	}

	/**JPQL**/
	public List<Produit> retrieveByDateCreation(Date dateCreation) {
		return detailProduitRepository.findByDateCreation(dateCreation);
	}

	public List<Produit> retrieveByDateCreationBetween(Date startDate, Date endDate) {
		return detailProduitRepository.findByDateCreationBetween(startDate,endDate);
	}

	public List<Produit> retrieveByDateCreationBefore(Date dateBefore) {
		return detailProduitRepository.findByDateCreationBefore(dateBefore);
	}

	/*public List<Produit> retrieveByCategorieProduit(CategorieProduit categorieProduit) {
		return detailProduitRepository.findByCategorieProduit(categorieProduit);
	}*/

	public List<Produit> retrieveByDateDernieremodification(Date derniereModification) {
		return detailProduitRepository.findByDateDernieremodification(derniereModification);
	}

}
