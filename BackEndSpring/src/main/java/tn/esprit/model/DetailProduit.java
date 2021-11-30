package tn.esprit.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DetailProduit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idDetailProduit;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateCreation;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date datDernieremodification;
	
	@Enumerated(EnumType.ORDINAL)

	private CategorieProduit categorieProduit;
	@OneToOne(mappedBy="detailProduit")
	private Produit produit;

}
