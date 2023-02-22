package io.zenwave360.example.core.implementation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.config.*;
import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.implementation.mappers.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import io.zenwave360.example.core.outbound.jpa.*;
import io.zenwave360.example.core.outbound.search.*;
import io.zenwave360.example.infrastructure.jpa.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

/** Acceptance Test for CustomerOrderUseCases. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerOrderUseCasesTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  InMemoryTestsManualContext context = InMemoryTestsManualContext.INSTANCE;
  CustomerOrderUseCasesImpl customerOrderUseCases = context.customerOrderUseCases();

  CustomerOrderRepositoryInMemory customerOrderRepository = context.customerOrderRepository();

  @BeforeEach
  void setUp() {
    customerOrderRepository.clear();
    customerOrderRepository.save(new CustomerOrder());
  }

  // CustomerOrder

  @Test
  @Order(01)
  void testCRUDCustomerOrder() {
    var input = new CustomerOrderInput();
    // TODO fill input data
    var customerOrder = customerOrderUseCases.createCustomerOrder(input);
    assertNotNull(customerOrder.getId());
    assertTrue(customerOrderRepository.containsEntity(customerOrder));

    var id = customerOrder.getId();
    var customerOrderUpdate = new CustomerOrderInput();
    // TODO fill update data
    assertTrue(customerOrderRepository.containsKey(id));
    var customerOrderUpdated = customerOrderUseCases.updateCustomerOrder(id, customerOrderUpdate);
    assertTrue(customerOrderUpdated.isPresent());
    assertTrue(customerOrderRepository.containsEntity(customerOrderUpdated.get()));

    assertTrue(customerOrderRepository.containsKey(id));
    customerOrderUseCases.deleteCustomerOrder(id);
    assertFalse(customerOrderRepository.containsKey(id));
  }

  @Test
  @Order(02)
  void testCreateCustomerOrder() {
    var input = new CustomerOrderInput();
    // TODO fill input data
    var customerOrder = customerOrderUseCases.createCustomerOrder(input);
    assertNotNull(customerOrder.getId());
    assertTrue(customerOrderRepository.containsEntity(customerOrder));
  }

  @Test
  @Order(03)
  void testUpdateCustomerOrder() {
    var id = 0L; // TODO fill id
    var input = new CustomerOrderInput();
    // TODO fill input data
    assertTrue(customerOrderRepository.containsKey(id));
    var customerOrder = customerOrderUseCases.updateCustomerOrder(id, input);
    assertTrue(customerOrder.isPresent());
    assertTrue(customerOrderRepository.containsEntity(customerOrder.get()));
  }

  @Test
  @Order(04)
  void testListCustomerOrders() {
    var results = customerOrderUseCases.listCustomerOrders(PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  @Order(05)
  void testSearchCustomerOrders() {
    var criteria = new CustomerOrderSearchCriteria();
    // TODO fill criteria
    var results = customerOrderUseCases.searchCustomerOrders(criteria, PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  @Order(06)
  void testGetCustomerOrder() {
    var id = 0L; // TODO fill id
    var customerOrder = customerOrderUseCases.getCustomerOrder(id);
    assertTrue(customerOrder.isPresent());
  }

  @Test
  @Order(07)
  void testDeleteCustomerOrder() {
    var id = 0L; // TODO fill id
    assertTrue(customerOrderRepository.containsKey(id));
    customerOrderUseCases.deleteCustomerOrder(id);
    assertFalse(customerOrderRepository.containsKey(id));
  }
}
