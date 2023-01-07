package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class OrderShippingDetailsInput implements Serializable {

  private String address;

  private String phone;

  public OrderShippingDetailsInput withAddress(String address) {
    this.address = address;
    return this;
  }

  public OrderShippingDetailsInput withPhone(String phone) {
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
