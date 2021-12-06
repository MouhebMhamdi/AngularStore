package tn.esprit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idCategory;

  private String nomCategory;


  @OneToMany(mappedBy="category",cascade=CascadeType.ALL)
  @Nullable
  @ToString.Exclude
  @JsonIgnore
  @NotFound(action = NotFoundAction.IGNORE)
  private Set<SubCategory> subCategories;
}




