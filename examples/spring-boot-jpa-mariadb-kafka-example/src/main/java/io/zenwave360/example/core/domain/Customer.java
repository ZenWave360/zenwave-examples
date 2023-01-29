package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/** */
@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer extends BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Version private Integer version;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "first_name", nullable = false, length = 250)
  private String firstName;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "last_name", nullable = false, length = 250)
  private String lastName;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "password", nullable = false, length = 250)
  private String password;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "email", nullable = false, length = 250)
  private String email;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "username", nullable = false, length = 250)
  private String username;

  @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
  private Set<ShippingDetails> shipmentDetails;

  @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
  private Set<PaymentDetails> paymentDetails;

  public Long getId() {
    return id;
  }

  public Customer withId(Long id) {
    this.id = id;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Customer withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public Customer withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Customer withPassword(String password) {
    this.password = password;
    return this;
  }

  public Customer withEmail(String email) {
    this.email = email;
    return this;
  }

  public Customer withUsername(String username) {
    this.username = username;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Set<ShippingDetails> getShipmentDetails() {
    return shipmentDetails;
  }

  public void setShipmentDetails(Set<ShippingDetails> shipmentDetails) {
    this.shipmentDetails = shipmentDetails;
  }

  public Set<PaymentDetails> getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(Set<PaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
  }
}
