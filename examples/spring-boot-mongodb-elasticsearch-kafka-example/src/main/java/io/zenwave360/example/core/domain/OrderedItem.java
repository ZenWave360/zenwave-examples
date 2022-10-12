package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.data.mongodb.core.mapping.Field;

/** */
public class OrderedItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Field private Long catalogItemId;

  @Field
  // @minlength("3")// @maxlength("250")// @required("")
  private String name;

  @Field private Integer quantity;

  @Field
  // @required("")
  private BigDecimal price;

  public OrderedItem withCatalogItemId(Long catalogItemId) {
    this.catalogItemId = catalogItemId;
    return this;
  }

  public OrderedItem withName(String name) {
    this.name = name;
    return this;
  }

  public OrderedItem withQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  public OrderedItem withPrice(BigDecimal price) {
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
