package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class OrderedItemInput implements Serializable {

  private Long id;

  private Integer version;

  private Long catalogItemId;

  @NotNull
  @Size(min = 3, max = 250)
  private String name;

  private Integer quantity;

  @NotNull private BigDecimal price;

  // {type=ManyToMany, _relationship={isInjectedFieldInFromRequired=false, commentInFrom=null,
  // injectedFieldInFrom=orderedItems(name), commentInTo=null,
  // injectedFieldInTo=customerOrders(username), options={destination={}, global={}, source={}},
  // from=CustomerOrder, to=OrderedItem, type=ManyToMany, isInjectedFieldInToRequired=false},
  // otherEntityName=CustomerOrder, ownerSide=false, isCollection=true, fieldName=customerOrders,
  // otherEntityFieldName=orderedItems}
  private Set<CustomerOrderInput> customerOrders = new HashSet<>();

  public Long getId() {
    return id;
  }

  public OrderedItemInput withId(Long id) {
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

  public Set<CustomerOrderInput> getCustomerOrders() {
    return customerOrders;
  }

  public void setCustomerOrder(Set<CustomerOrderInput> customerOrders) {
    this.customerOrders = customerOrders;
  }
}
