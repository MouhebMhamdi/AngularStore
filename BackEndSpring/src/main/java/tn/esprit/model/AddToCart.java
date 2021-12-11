package tn.esprit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "add_to_cart")
public class AddToCart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  @JsonIgnore //aalech melowl kent tjini
  @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
  @JoinColumn(name = "product_id")
    Produit produit;

  int qty;
  String added_Date;

  long user_id;

  public Produit getProduit() {
    return produit;
  }

  public void setProduit(Produit produit) {
    this.produit = produit;
  }

  double price;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }





  public int getQty() {
    return qty;
  }

  public void setQty(int qty) {
    this.qty = qty;
  }

  public String getAdded_Date() {
    return added_Date;
  }

  public void setAdded_Date(String added_Date) {
    this.added_Date = added_Date;
  }
}
