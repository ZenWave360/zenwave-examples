package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class CustomerOrderInput implements Serializable {

  private Long id;

  private Integer version;

  private Instant date;

  private OrderShippingDetailsInput shippingDetails;

  private OrderStatus status;

  // {type=ManyToMany, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=orderedItems(name), commentInTo=null,
  // injectedFieldInTo=customerOrders(username), options={destination={}, global={}, source={}},
  // from=CustomerOrder, to=OrderedItem, type=ManyToMany, isInjectedFieldInToRequired=false},
  // otherEntityName=OrderedItem, ownerSide=true, isCollection=true, fieldName=orderedItems,
  // otherEntityFieldName=customerOrders}
  private Set<OrderedItemInput> orderedItems = new HashSet<>();

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=customer(username), commentInTo=null, injectedFieldInTo=null,
  // options={destination={}, global={}, source={}}, from=CustomerOrder, to=Customer,
  // type=ManyToOne, isInjectedFieldInToRequired=null}, otherEntityName=Customer, ownerSide=true,
  // isCollection=false, fieldName=customer}

  private Long customerId;

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=paymentDetails(creditCardNumber), commentInTo=null, injectedFieldInTo=null,
  // options={destination={}, global={}, source={}}, from=CustomerOrder, to=PaymentDetails,
  // type=ManyToOne, isInjectedFieldInToRequired=null}, otherEntityName=PaymentDetails,
  // ownerSide=true, isCollection=false, fieldName=paymentDetails}

  private Long paymentDetailsId;

  public Long getId() {
    return id;
  }

  public CustomerOrderInput withId(Long id) {
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

  public CustomerOrderInput withDate(Instant date) {
    this.date = date;
    return this;
  }

  public CustomerOrderInput withShippingDetails(OrderShippingDetailsInput shippingDetails) {
    this.shippingDetails = shippingDetails;
    return this;
  }

  public CustomerOrderInput withStatus(OrderStatus status) {
    this.status = status;
    return this;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public OrderShippingDetailsInput getShippingDetails() {
    return shippingDetails;
  }

  public void setShippingDetails(OrderShippingDetailsInput shippingDetails) {
    this.shippingDetails = shippingDetails;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Set<OrderedItemInput> getOrderedItems() {
    return orderedItems;
  }

  public void setOrderedItem(Set<OrderedItemInput> orderedItems) {
    this.orderedItems = orderedItems;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getPaymentDetailsId() {
    return paymentDetailsId;
  }

  public void setPaymentDetailsId(Long paymentDetailsId) {
    this.paymentDetailsId = paymentDetailsId;
  }
}
