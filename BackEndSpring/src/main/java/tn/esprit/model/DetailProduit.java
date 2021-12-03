package tn.esprit.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class DetailProduit implements Serializable {
	/*****Les attributs*****/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailProduit;

	@NotNull
	@CreatedDate
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateCreation;

	@NotNull
	@LastModifiedDate
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateDerniereModification;


	@NotNull
	@Enumerated(EnumType.STRING)
	private CategorieProduit categorieProduit;

	/*****Les associations*****/
	@Nullable
	@NotFound(action = NotFoundAction.IGNORE)
	@OneToOne(mappedBy="detailProduit")
	@ToString.Exclude
	private Produit produit;



}
