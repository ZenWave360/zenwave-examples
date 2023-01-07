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
@Table(name = "payment_details")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PaymentDetails implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  @Column(name = "id")
  private Long id;

  @Version private Integer version;

  @Column(name = "card_holder_name")
  private String cardHolderName;

  @Column(name = "credit_card_number")
  private String creditCardNumber;

  @Column(name = "customer_id")
  private Long customerId;

  @ManyToOne()
  @JoinColumn(name = "customer_id", updatable = false, insertable = false)
  private Customer customer;

  public Long getId() {
    return id;
  }

  public PaymentDetails withId(Long id) {
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

  public PaymentDetails withCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
    return this;
  }

  public PaymentDetails withCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
    return this;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
