package io.zenwave360.example.core.domain;

/** Enum for OrderStatus. */
public enum OrderStatus {
  DELIVERED("DELIVERED"),
  CONFIRMED("CONFIRMED"),
  SHIPPED("SHIPPED"),
  ;

  private final String value;

  private OrderStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
