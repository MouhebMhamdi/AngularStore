package tn.esprit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Rayon implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idRayon ;

	private String libelle;

	private String code ;


  @OneToMany(cascade = CascadeType.ALL, mappedBy="rayon")
  @JsonIgnore
  @ToString.Exclude
  private Set<Produit> produits;
}
