package tn.esprit.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Categories {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long IdCat;

  private String Name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy="categories")
  private Collection<Produit> produit;

  public  Categories(String NameCategorie){
    this.Name=NameCategorie;
  }

}
