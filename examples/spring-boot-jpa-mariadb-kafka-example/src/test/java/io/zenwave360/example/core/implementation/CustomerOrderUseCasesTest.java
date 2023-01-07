package io.zenwave360.example.core.implementation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.implementation.mappers.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import io.zenwave360.example.core.outbound.jpa.*;
import io.zenwave360.example.core.outbound.search.*;
import io.zenwave360.example.infrastructure.jpa.inmemory.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

/** Acceptance Test for CustomerOrderUseCases. */
public class CustomerOrderUseCasesTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Spy CustomerOrderMapper customerOrderMapper = Mappers.getMapper(CustomerOrderMapper.class);
  @Spy CustomerOrderRepositoryInMemory customerOrderRepository = new CustomerOrderRepositoryInMemory();

  @InjectMocks CustomerOrderUseCasesImpl customerOrderUseCases;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    customerOrderRepository.save(new CustomerOrder());
  }

  // CustomerOrder

  @Test
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
  void testCreateCustomerOrder() {
    var input = new CustomerOrderInput();
    // TODO fill input data
    var customerOrder = customerOrderUseCases.createCustomerOrder(input);
    assertNotNull(customerOrder.getId());
    assertTrue(customerOrderRepository.containsEntity(customerOrder));
  }

  @Test
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
  void testListCustomerOrders() {
    var results = customerOrderUseCases.listCustomerOrders(PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  void testSearchCustomerOrders() {
    var criteria = new CustomerOrderSearchCriteria();
    // TODO fill criteria
    var results = customerOrderUseCases.searchCustomerOrders(criteria, PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  void testGetCustomerOrder() {
    var id = 0L; // TODO fill id
    var customerOrder = customerOrderUseCases.getCustomerOrder(id);
    assertTrue(customerOrder.isPresent());
  }

  @Test
  void testDeleteCustomerOrder() {
    var id = 0L; // TODO fill id
    assertTrue(customerOrderRepository.containsKey(id));
    customerOrderUseCases.deleteCustomerOrder(id);
    assertFalse(customerOrderRepository.containsKey(id));
  }
}
