package tn.esprit.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Facture implements  Serializable{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)

    @Nullable
 		private long idFacture ;
  @Nullable

  private float montantRemise ;
  private float montantFacture ;

  public String getEtat() {
    return etat;
  }

  public void setEtat(String etat) {
    this.etat = etat;
  }

  private String etat ;

  public float getMontantFacture() {
    return montantFacture;
  }

  public void setMontantFacture(float montantFacture) {
    this.montantFacture = montantFacture;
  }

  public long getIdFacture() {
    return idFacture;
  }

  public void setIdFacture(long idFacture) {
    this.idFacture = idFacture;
  }

  public float getMontantRemise() {
    return montantRemise;
  }

  public void setMontantRemise(float montantRemise) {
    this.montantRemise = montantRemise;
  }

  public float getIdmontantFacture() {
    return idmontantFacture;
  }

  public void setIdmontantFacture(float idmontantFacture) {
    this.idmontantFacture = idmontantFacture;
  }

  public Date getDateFacture() {
    return DateFacture;
  }

  public void setDateFacture(Date dateFacture) {
    DateFacture = dateFacture;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Set<DetailFacture> getDetailFactures() {
    return detailFactures;
  }

  public void setDetailFactures(Set<DetailFacture> detailFactures) {
    this.detailFactures = detailFactures;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Nullable

	 	private float idmontantFacture ;
	 	@Temporal(value=TemporalType.TIMESTAMP)
		private Date DateFacture  ;
		private boolean active  ;


  @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER, mappedBy="facture")
		private Set<DetailFacture> detailFactures;

		@ManyToOne
		User user;



}
