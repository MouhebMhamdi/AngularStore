package tn.esprit.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  idProduit; 
	private String  code; 
	private String  idlibelle;
	private float  idprixUnitaire;

	@ManyToMany(targetEntity=Fournisseur.class,cascade=CascadeType.MERGE)
	private Set<Fournisseur> fournisseurProduit;


	@ManyToOne
	Rayon rayon;
	@ManyToOne
	DetailFacture detailFacture;
	@OneToOne
	private DetailProduit detailProduit;
	@ManyToOne
	Stock stock;



	


}
