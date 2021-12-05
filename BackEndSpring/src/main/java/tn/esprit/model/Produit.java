package tn.esprit.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="produit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long  idProduit;
	private String  code;
	private String  libelle;
	private float  prixUnitaire;

	@ManyToMany(targetEntity=Fournisseur.class,cascade=CascadeType.MERGE)
	private Set<Fournisseur> fournisseurProduit;


	@ManyToOne
	Rayon rayon;
	@ManyToOne
	DetailFacture detailFacture;

  @Temporal(value=TemporalType.TIMESTAMP)
  private Date dateCreation;
  @Temporal(value=TemporalType.TIMESTAMP)
  private Date datDernieremodification;

  @ManyToOne
	Stock stock;

  @ManyToOne
  private Categories categories;




}
