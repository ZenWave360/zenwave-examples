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
@Table(name = "ordered_item")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderedItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Version private Integer version;

  @Column(name = "catalog_item_id")
  private Long catalogItemId;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "name", nullable = false, length = 250)
  private String name;

  @Column(name = "quantity")
  private Integer quantity;

  @NotNull
  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @ManyToMany(mappedBy = "orderedItems")
  private Set<CustomerOrder> customerOrders;

  public Long getId() {
    return id;
  }

  public OrderedItem withId(Long id) {
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

  public Set<CustomerOrder> getCustomerOrders() {
    return customerOrders;
  }

  public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
    this.customerOrders = customerOrders;
  }
}
