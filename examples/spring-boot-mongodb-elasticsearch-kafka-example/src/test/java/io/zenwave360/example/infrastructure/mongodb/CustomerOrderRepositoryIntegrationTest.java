package io.zenwave360.example.infrastructure.mongodb;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.mongodb.CustomerOrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerOrderRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

  @Autowired CustomerOrderRepository customerOrderRepository;

  @Test
  public void findAllTest() {
    var results = customerOrderRepository.findAll();
    Assertions.assertFalse(results.isEmpty());
  }

  @Test
  public void findByIdTest() {
    var id = "1";
    var customerOrder = customerOrderRepository.findById(id).orElseThrow();
    Assertions.assertTrue(customerOrder.getId() != null);
    Assertions.assertTrue(customerOrder.getVersion() != null);
  }

  @Test
  public void saveTest() {
    CustomerOrder customerOrder = new CustomerOrder();
    customerOrder.setDate(null);
    customerOrder.setShippingDetails(null);
    customerOrder.setOrderedItems(null);
    customerOrder.setPaymentDetails(null);
    customerOrder.setStatus(null);
    customerOrder.setCustomer(null);

    var created = customerOrderRepository.save(customerOrder);
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);
  }

  @Test
  public void updateTest() {
    var id = "1";
    var customerOrder = customerOrderRepository.findById(id).orElseThrow();
    customerOrder.setDate(null);
    customerOrder.setShippingDetails(null);
    customerOrder.setOrderedItems(null);
    customerOrder.setPaymentDetails(null);
    customerOrder.setStatus(null);
    customerOrder.setCustomer(null);

    customerOrder = customerOrderRepository.save(customerOrder);
    Assertions.assertEquals("", customerOrder.getDate());
    Assertions.assertEquals("", customerOrder.getShippingDetails());
    Assertions.assertEquals("", customerOrder.getOrderedItems());
    Assertions.assertEquals("", customerOrder.getPaymentDetails());
    Assertions.assertEquals("", customerOrder.getStatus());
    Assertions.assertEquals("", customerOrder.getCustomer());
  }

  @Test
  public void deleteTest() {
    var id = "1";
    customerOrderRepository.deleteById(id);
    var notFound = customerOrderRepository.findById(id);
    Assertions.assertFalse(notFound.isPresent());
  }
}
