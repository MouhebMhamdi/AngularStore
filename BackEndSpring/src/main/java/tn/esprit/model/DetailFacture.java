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
public class DetailFacture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDetailFacture ;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateCreation ;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateDernierModification ;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="detailFacture")
	private Set<Produit> produits;
	@ManyToOne
	Facture facture;



}
