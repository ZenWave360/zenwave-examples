package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
@Document(collection = "CustomerOrder")
public class CustomerOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id private String id;

  @Field private Instant date;

  @Field private ShippingDetails shippingDetails;

  @Field private List<OrderedItem> orderedItems;

  @Field private List<PaymentDetails> paymentDetails;

  @Field private OrderStatus status;

  @DocumentReference private Customer customer;

  public String getId() {
    return id;
  }

  public CustomerOrder withId(String id) {
    this.id = id;
    return this;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomerOrder withDate(Instant date) {
    this.date = date;
    return this;
  }

  public CustomerOrder withShippingDetails(ShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
    return this;
  }

  public CustomerOrder addOrderedItems(OrderedItem orderedItems) {
    this.orderedItems.add(orderedItems);
    return this;
  }

  public CustomerOrder withOrderedItems(List<OrderedItem> orderedItems) {
    this.orderedItems = orderedItems;
    return this;
  }

  public CustomerOrder addPaymentDetails(PaymentDetails paymentDetails) {
    this.paymentDetails.add(paymentDetails);
    return this;
  }

  public CustomerOrder withPaymentDetails(List<PaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
    return this;
  }

  public CustomerOrder withStatus(OrderStatus status) {
    this.status = status;
    return this;
  }

  public CustomerOrder withCustomer(Customer customer) {
    this.customer = customer;
    return this;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public ShippingDetails getShippingDetails() {
    return shippingDetails;
  }

  public void setShippingDetails(ShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
  }

  public List<OrderedItem> getOrderedItems() {
    return orderedItems;
  }

  public void setOrderedItems(List<OrderedItem> orderedItems) {
    this.orderedItems = orderedItems;
  }

  public List<PaymentDetails> getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
    this.paymentDetails = paymentDetails;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
