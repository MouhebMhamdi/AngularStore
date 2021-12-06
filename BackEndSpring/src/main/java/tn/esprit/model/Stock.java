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
public class Stock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idStock;
	private int qte;
	private int qtemin ;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
  @JsonIgnore
  @ToString.Exclude
  private Set<Produit> produits;

}
