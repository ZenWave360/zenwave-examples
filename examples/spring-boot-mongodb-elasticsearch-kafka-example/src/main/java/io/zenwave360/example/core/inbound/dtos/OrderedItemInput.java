package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class OrderedItemInput implements Serializable {

  private Long catalogItemId;

  // @minlength("3")

  // @maxlength("250")

  // @required("")

  private String name;

  private Integer quantity;

  // @required("")

  private BigDecimal price;

  public OrderedItemInput withCatalogItemId(Long catalogItemId) {
    this.catalogItemId = catalogItemId;
    return this;
  }

  public OrderedItemInput withName(String name) {
    this.name = name;
    return this;
  }

  public OrderedItemInput withQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  public OrderedItemInput withPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public Long getCatalogItemId() {
    return catalogItemId;
  }

  public void setCatalogItemId(Long catalogItemId) {
    this.catalogItemId = catalogItemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
