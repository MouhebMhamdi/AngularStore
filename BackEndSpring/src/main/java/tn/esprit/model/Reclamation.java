package tn.esprit.model;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Reclamation implements Serializable {
  /*****Les attributs*****/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idReclamation;
  @NotNull
  private String typeReclamation;

  @NotNull
  private String name;

  @NotNull
  private String phoneNumber;

  @NotNull
  private String message ;

  @NotNull
  private String email ;



}
