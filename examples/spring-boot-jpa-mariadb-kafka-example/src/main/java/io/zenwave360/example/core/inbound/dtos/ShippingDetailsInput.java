package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class ShippingDetailsInput implements Serializable {

  private Long id;

  private Integer version;

  private String phone;

  private String address;

  // {type=ManyToOne, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=customer, commentInTo=null, injectedFieldInTo=shipmentDetails,
  // options={destination={}, global={}, source={}}, from=ShippingDetails, to=Customer,
  // type=ManyToOne, isInjectedFieldInToRequired=false}, otherEntityName=Customer, ownerSide=true,
  // isCollection=false, fieldName=customer, otherEntityFieldName=shipmentDetails}

  private Long customerId;

  public Long getId() {
    return id;
  }

  public ShippingDetailsInput withId(Long id) {
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

  public ShippingDetailsInput withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public ShippingDetailsInput withAddress(String address) {
    this.address = address;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
