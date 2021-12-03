package tn.esprit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.Nullable;
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
  /*****Les attribtus*****/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long  idProduit;
  @NotNull
  private String  code;
  @NotNull
  private String  libelle;
  @NotNull
  private float  prixUnitaire;
  @NotNull
  private String image;
  @NotNull
  private int nbrlikes;

  /*****Les associations*****/
  @Nullable
  @NotFound(action = NotFoundAction.IGNORE)
  @ManyToMany(cascade = CascadeType.ALL)
  @JsonIgnore
  Set<Fournisseur> fournisseurs;

  @Nullable
  @NotFound(action = NotFoundAction.IGNORE)
  @ManyToOne
  @JsonIgnore
  private Rayon rayon;

  @Nullable
  @NotFound(action = NotFoundAction.IGNORE)
  @ManyToOne
  @ToString.Exclude
  @JsonIgnore
  private Stock stock;

  @Nullable
  @NotFound(action = NotFoundAction.IGNORE)
  @ManyToOne
  @JsonIgnore
  private DetailFacture detailFacture;

  @Nullable
  @NotFound(action = NotFoundAction.IGNORE)
  @OneToOne
  @JsonIgnore
  private DetailProduit detailProduit;


}
