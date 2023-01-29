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
import io.zenwave360.example.core.outbound.mongodb.*;
import io.zenwave360.example.core.outbound.search.*;
import io.zenwave360.example.infrastructure.mongodb.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

/** Acceptance Test for CustomerUseCases. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerUseCasesTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  InMemoryTestsManualContext context = InMemoryTestsManualContext.INSTANCE;
  CustomerUseCasesImpl customerUseCases = context.customerUseCases();

  CustomerRepositoryInMemory customerRepository = context.customerRepository();
  CustomerSearchRepository customerSearchRepository = context.customerSearchRepository();

  @BeforeEach
  void setUp() {
    customerRepository.save(new Customer());
  }

  // Customer

  @Test
  @Order(01)
  void testCRUDCustomer() {
    var input = new CustomerInput();
    // TODO fill input data
    var customer = customerUseCases.createCustomer(input);
    assertNotNull(customer.getId());
    assertTrue(customerRepository.containsEntity(customer));

    var id = customer.getId();
    var customerUpdate = new CustomerInput();
    // TODO fill update data
    assertTrue(customerRepository.containsKey(id));
    var customerUpdated = customerUseCases.updateCustomer(id, customerUpdate);
    assertTrue(customerUpdated.isPresent());
    assertTrue(customerRepository.containsEntity(customerUpdated.get()));

    assertTrue(customerRepository.containsKey(id));
    customerUseCases.deleteCustomer(id);
    assertFalse(customerRepository.containsKey(id));
  }

  @Test
  @Order(02)
  void testCreateCustomer() {
    var input = new CustomerInput();
    // TODO fill input data
    var customer = customerUseCases.createCustomer(input);
    assertNotNull(customer.getId());
    assertTrue(customerRepository.containsEntity(customer));
  }

  @Test
  @Order(03)
  void testUpdateCustomer() {
    var id = "0"; // TODO fill id
    var input = new CustomerInput();
    // TODO fill input data
    assertTrue(customerRepository.containsKey(id));
    var customer = customerUseCases.updateCustomer(id, input);
    assertTrue(customer.isPresent());
    assertTrue(customerRepository.containsEntity(customer.get()));
  }

  @Test
  @Order(04)
  void testListCustomers() {
    var results = customerUseCases.listCustomers(PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  @Order(05)
  void testSearchCustomers() {
    var criteria = new CustomerCriteria();
    // TODO fill criteria
    var results = customerUseCases.searchCustomers(criteria, PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  @Order(06)
  void testGetCustomer() {
    var id = "0"; // TODO fill id
    var customer = customerUseCases.getCustomer(id);
    assertTrue(customer.isPresent());
  }

  @Test
  @Order(07)
  void testDeleteCustomer() {
    var id = "0"; // TODO fill id
    assertTrue(customerRepository.containsKey(id));
    customerUseCases.deleteCustomer(id);
    assertFalse(customerRepository.containsKey(id));
  }
}
