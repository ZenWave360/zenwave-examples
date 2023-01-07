package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

/** */
@Embeddable
public class OrderShippingDetails implements Serializable {

  private static final long serialVersionUID = 1L;

  @Column(name = "address")
  private String address;

  @Column(name = "phone")
  private String phone;

  public OrderShippingDetails withAddress(String address) {
    this.address = address;
    return this;
  }

  public OrderShippingDetails withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
