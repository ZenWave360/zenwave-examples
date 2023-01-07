package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class CustomerInput extends BaseEntityInput implements Serializable {

  private Long id;

  private Integer version;

  @NotNull
  @Size(min = 3, max = 250)
  private String firstName;

  @NotNull
  @Size(min = 3, max = 250)
  private String lastName;

  @NotNull
  @Size(min = 3, max = 250)
  private String password;

  @NotNull
  @Size(min = 3, max = 250)
  private String email;

  @NotNull
  @Size(min = 3, max = 250)
  private String username;

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=customer(username), commentInTo=null, injectedFieldInTo=null,
  // options={destination={}, global={}, source={}}, from=CustomerOrder, to=Customer,
  // type=ManyToOne, isInjectedFieldInToRequired=null}, otherEntityName=CustomerOrder,
  // ownerSide=false, isCollection=true, otherEntityFieldName=customer}

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=customer, commentInTo=null, injectedFieldInTo=shipmentDetails,
  // options={destination={}, global={}, source={}}, from=ShippingDetails, to=Customer,
  // type=ManyToOne, isInjectedFieldInToRequired=false}, otherEntityName=ShippingDetails,
  // ownerSide=false, isCollection=true, fieldName=shipmentDetails, otherEntityFieldName=customer}
  private Set<ShippingDetailsInput> shipmentDetails = new HashSet<>();

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=customer, commentInTo=null, injectedFieldInTo=paymentDetails,
  // options={destination={}, global={}, source={}}, from=PaymentDetails, to=Customer,
  // type=ManyToOne, isInjectedFieldInToRequired=false}, otherEntityName=PaymentDetails,
  // ownerSide=false, isCollection=true, fieldName=paymentDetails, otherEntityFieldName=customer}
  private Set<PaymentDetailsInput> paymentDetails = new HashSet<>();

  public Long getId() {
    return id;
  }

  public CustomerInput withId(Long id) {
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

  public CustomerInput withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public CustomerInput withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public CustomerInput withPassword(String password) {
    this.password = password;
    return this;
  }

  public CustomerInput withEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerInput withUsername(String username) {
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

  public Set<ShippingDetailsInput> getShipmentDetails() {
    return shipmentDetails;
  }

  public void setShippingDetails(Set<ShippingDetailsInput> shipmentDetails) {
    this.shipmentDetails = shipmentDetails;
  }

  public Set<PaymentDetailsInput> getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(Set<PaymentDetailsInput> paymentDetails) {
    this.paymentDetails = paymentDetails;
  }
}
