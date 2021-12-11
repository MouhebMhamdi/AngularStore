package tn.esprit.model;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long idClient ;
	private String  Nom ;
	private String Prenom ;

	@Temporal(value=TemporalType.TIMESTAMP)
	private Date DateNaissance ;

	private String email ;
	private String password;

  private String city;
  private String State;
  private int zip;
  private String tel;
  private String street;
	private String proffesion;
  private String docName ;
  private String docType ;
  private String genre;


	@OneToMany(cascade= { CascadeType.REMOVE}, fetch=FetchType.EAGER, mappedBy= "user")
	private Set<Facture> factures;

	@ManyToMany(fetch = FetchType.EAGER, cascade= { CascadeType.REMOVE})
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "idClient"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;





}
