package tn.esprit.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "checkout_cart")
public class CheckOutCart implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  String order_id,payment_type,delivery_address;
  long user_id;

  @OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
  @JoinColumn(name = "product_id")
  Produit product;
  //long ;
  int qty;
  double price;
  @Column(updatable=false, insertable=false)
  String order_date;
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getOrder_id() {
    return order_id;
  }
  public void setOrder_id(String order_id) {
    this.order_id = order_id;
  }

  public String getPayment_type() {
    return payment_type;
  }
  public void setPayment_type(String payment_type) {
    this.payment_type = payment_type;
  }
  public String getDelivery_address() {
    return delivery_address;
  }
  public void setDelivery_address(String delivery_address) {
    this.delivery_address = delivery_address;
  }
  //	public long getProduct_id() {
//		return product_id;
//	}
//	public void setProduct_id(long product_id) {
//		this.product_id = product_id;
//	}
  public int getQty() {
    return qty;
  }
  public void setQty(int qty) {
    this.qty = qty;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public String getOrder_date() {
    return order_date;
  }
  public void setOrder_date(String order_date) {
    this.order_date = order_date;
  }
  public long getUser_id() {
    return user_id;
  }
  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }
  public Produit getProduct() {
    return product;
  }
  public void setProduct(Produit product) {
    this.product = product;
  }
}
