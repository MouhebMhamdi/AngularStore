package tn.esprit.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Fournisseur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFournisseur ;
	private String code;
	private String libelle;
	
	

	
	
}
