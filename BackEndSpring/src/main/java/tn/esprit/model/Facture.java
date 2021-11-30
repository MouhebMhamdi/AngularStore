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
public class Facture implements  Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	
 		private long idFacture ;
	 	private float montantRemise ;
	 	private float idmontantFacture ;
	 	@Temporal(value=TemporalType.TIMESTAMP)
		private Date DateFacture  ;
		private boolean active  ;


		@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
		private Set<DetailFacture> detailFactures;

		@ManyToOne
		User user;


	 
}
