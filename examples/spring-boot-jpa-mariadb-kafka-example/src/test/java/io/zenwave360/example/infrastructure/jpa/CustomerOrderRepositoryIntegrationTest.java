package io.zenwave360.example.infrastructure.jpa;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.CustomerOrderRepository;
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
    var id = 1L;
    var customerOrder = customerOrderRepository.findById(id).orElseThrow();
    Assertions.assertTrue(customerOrder.getId() != null);
    Assertions.assertTrue(customerOrder.getVersion() != null);
  }

  @Test
  public void saveTest() {
    CustomerOrder customerOrder = new CustomerOrder();
    customerOrder.setDate(null);
    customerOrder.setShippingDetails(null);
    customerOrder.setStatus(null);

    var created = customerOrderRepository.save(customerOrder);
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);
  }

  @Test
  public void updateTest() {
    var id = 1L;
    var customerOrder = customerOrderRepository.findById(id).orElseThrow();
    customerOrder.setDate(null);
    customerOrder.setShippingDetails(null);
    customerOrder.setStatus(null);

    customerOrder = customerOrderRepository.save(customerOrder);
    Assertions.assertEquals("", customerOrder.getDate());
    Assertions.assertEquals("", customerOrder.getShippingDetails());
    Assertions.assertEquals("", customerOrder.getStatus());
  }

  @Test
  public void deleteTest() {
    var id = 1L;
    customerOrderRepository.deleteById(id);
    var notFound = customerOrderRepository.findById(id);
    Assertions.assertFalse(notFound.isPresent());
  }
}
