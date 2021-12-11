package tn.esprit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

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

  @Cascade(org.hibernate.annotations.CascadeType.REMOVE)

  @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER, mappedBy="rayon")
  @JsonIgnore
  @ToString.Exclude
  private Set<Produit> produits;
}
