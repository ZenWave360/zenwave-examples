package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class CustomerOrderInput implements Serializable {

    private String id;

    private Instant date;

    private ShippingDetailsInput shippingDetails;

    private List<OrderedItemInput> orderedItems;

    private List<PaymentDetailsInput> paymentDetails;

    private OrderStatus status;

    private CustomerInput customer;

    public String getId() {
        return id;
    }

    public CustomerOrderInput withId(String id) {
        this.id = id;
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerOrderInput withDate(Instant date) {
        this.date = date;
        return this;
    }

    public CustomerOrderInput withShippingDetails(ShippingDetailsInput shippingDetails) {
        this.shippingDetails = shippingDetails;
        return this;
    }

    public CustomerOrderInput addOrderedItems(OrderedItemInput orderedItems) {
        this.orderedItems.add(orderedItems);
        return this;
    }

    public CustomerOrderInput withOrderedItems(List<OrderedItemInput> orderedItems) {
        this.orderedItems = orderedItems;
        return this;
    }

    public CustomerOrderInput addPaymentDetails(PaymentDetailsInput paymentDetails) {
        this.paymentDetails.add(paymentDetails);
        return this;
    }

    public CustomerOrderInput withPaymentDetails(List<PaymentDetailsInput> paymentDetails) {
        this.paymentDetails = paymentDetails;
        return this;
    }

    public CustomerOrderInput withStatus(OrderStatus status) {
        this.status = status;
        return this;
    }

    public CustomerOrderInput withCustomer(CustomerInput customer) {
        this.customer = customer;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public ShippingDetailsInput getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetailsInput shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public List<OrderedItemInput> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderedItemInput> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public List<PaymentDetailsInput> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetailsInput> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public CustomerInput getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerInput customer) {
        this.customer = customer;
    }
}
