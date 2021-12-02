package tn.esprit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "add_to_cart")
public class AddToCart {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  long product_id;
  int qty;
  String added_Date;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(long product_id) {
    this.product_id = product_id;
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
