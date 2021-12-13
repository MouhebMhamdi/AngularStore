package tn.esprit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSubCategory;

    @Column
    private String nameSubCategory;
  @Cascade(org.hibernate.annotations.CascadeType.REMOVE)

  @Nullable
    @ManyToOne(fetch = FetchType.EAGER)  //multiple subcategories can have one category
    @NotFound(action = NotFoundAction.IGNORE)
    private Category category;


  @OneToMany(mappedBy="subCategory",cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
  @Nullable
  @ToString.Exclude
  @JsonIgnore
  @NotFound(action = NotFoundAction.IGNORE)
  private Set<Produit> produits;


}
