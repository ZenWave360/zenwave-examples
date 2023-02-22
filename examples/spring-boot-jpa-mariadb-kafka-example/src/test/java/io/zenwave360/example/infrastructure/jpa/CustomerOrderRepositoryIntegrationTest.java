package io.zenwave360.example.infrastructure.jpa;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.CustomerOrderRepository;
import java.math.BigDecimal;
import java.time.*;
import java.util.HashSet;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerOrderRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

  @Autowired EntityManager entityManager;

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
    customerOrder.setDate(Instant.now());
    customerOrder.setShippingDetails(new OrderShippingDetails());
    customerOrder.setStatus(OrderStatus.values()[0]);

    // ManyToMany orderedItems owner: true
    var orderedItems = new OrderedItem();
    orderedItems.setCatalogItemId(0L);
    orderedItems.setName("aaa");
    orderedItems.setQuantity(0);
    orderedItems.setPrice(BigDecimal.valueOf(0));
    customerOrder.setOrderedItems(new HashSet<>());
    customerOrder.getOrderedItems().add(orderedItems);

    // ManyToOne customer owner: true
    var customerId = 1L;
    customerOrder.setCustomerId(customerId); // using id to write relationship

    // ManyToOne paymentDetails owner: true
    var paymentDetailsId = 1L;
    customerOrder.setPaymentDetailsId(paymentDetailsId); // using id to write relationship

    // Persist aggregate root
    var created = customerOrderRepository.save(customerOrder);

    entityManager.refresh(created); // reloading to get relationships persisted by id
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);

    Assertions.assertTrue(customerOrder.getOrderedItems().stream().allMatch(item -> item.getId() != null));
    Assertions.assertTrue(customerOrder.getCustomer().getId() == customerId);
    Assertions.assertTrue(customerOrder.getPaymentDetails().getId() == paymentDetailsId);
  }

  @Test
  public void updateTest() {
    var id = 1L;
    var customerOrder = customerOrderRepository.findById(id).orElseThrow();
    customerOrder.setDate(Instant.now());
    customerOrder.setShippingDetails(new OrderShippingDetails());
    customerOrder.setStatus(OrderStatus.values()[0]);

    customerOrder = customerOrderRepository.save(customerOrder);
    Assertions.assertEquals(Instant.now(), customerOrder.getDate());
    Assertions.assertEquals(new OrderShippingDetails(), customerOrder.getShippingDetails());
    Assertions.assertEquals(OrderStatus.values()[0], customerOrder.getStatus());
  }

  @Test
  public void deleteTest() {
    var id = 1L;
    customerOrderRepository.deleteById(id);
    var notFound = customerOrderRepository.findById(id);
    Assertions.assertFalse(notFound.isPresent());
  }
}
