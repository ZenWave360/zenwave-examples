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
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

/** Acceptance Test for CustomerUseCases. */
public class CustomerUseCasesTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  InMemoryTestsManualContext context = InMemoryTestsManualContext.INSTANCE;
  CustomerUseCasesImpl customerUseCases = context.customerUseCases();

  CustomerRepositoryInMemory customerRepository = context.customerRepository();
  CustomerSearchRepository customerSearchRepository = context.customerSearchRepository();

  PaymentDetailsRepositoryInMemory paymentDetailsRepository = context.paymentDetailsRepository();

  ShippingDetailsRepositoryInMemory shippingDetailsRepository = context.shippingDetailsRepository();

  @BeforeEach
  void setUp() {
    customerRepository.save(new Customer());
    paymentDetailsRepository.save(new PaymentDetails());
    shippingDetailsRepository.save(new ShippingDetails());
  }

  // Customer

  @Test
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
  void testCreateCustomer() {
    var input = new CustomerInput();
    // TODO fill input data
    var customer = customerUseCases.createCustomer(input);
    assertNotNull(customer.getId());
    assertTrue(customerRepository.containsEntity(customer));
  }

  @Test
  void testUpdateCustomer() {
    var id = 0L; // TODO fill id
    var input = new CustomerInput();
    // TODO fill input data
    assertTrue(customerRepository.containsKey(id));
    var customer = customerUseCases.updateCustomer(id, input);
    assertTrue(customer.isPresent());
    assertTrue(customerRepository.containsEntity(customer.get()));
  }

  @Test
  void testListCustomers() {
    var results = customerUseCases.listCustomers(PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  void testSearchCustomers() {
    var criteria = new CustomerCriteria();
    // TODO fill criteria
    var results = customerUseCases.searchCustomers(criteria, PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  void testGetCustomer() {
    var id = 0L; // TODO fill id
    var customer = customerUseCases.getCustomer(id);
    assertTrue(customer.isPresent());
  }

  @Test
  void testDeleteCustomer() {
    var id = 0L; // TODO fill id
    assertTrue(customerRepository.containsKey(id));
    customerUseCases.deleteCustomer(id);
    assertFalse(customerRepository.containsKey(id));
  }

  // PaymentDetails

  @Test
  void testCRUDPaymentDetails() {
    var input = new PaymentDetailsInput();
    // TODO fill input data
    var paymentDetails = customerUseCases.createPaymentDetails(input);
    assertNotNull(paymentDetails.getId());
    assertTrue(paymentDetailsRepository.containsEntity(paymentDetails));

    var id = paymentDetails.getId();
    var paymentDetailsUpdate = new PaymentDetailsInput();
    // TODO fill update data
    assertTrue(paymentDetailsRepository.containsKey(id));
    var paymentDetailsUpdated = customerUseCases.updatePaymentDetails(id, paymentDetailsUpdate);
    assertTrue(paymentDetailsUpdated.isPresent());
    assertTrue(paymentDetailsRepository.containsEntity(paymentDetailsUpdated.get()));

    assertTrue(paymentDetailsRepository.containsKey(id));
    customerUseCases.deletePaymentDetails(id);
    assertFalse(paymentDetailsRepository.containsKey(id));
  }

  @Test
  void testCreatePaymentDetails() {
    var input = new PaymentDetailsInput();
    // TODO fill input data
    var paymentDetails = customerUseCases.createPaymentDetails(input);
    assertNotNull(paymentDetails.getId());
    assertTrue(paymentDetailsRepository.containsEntity(paymentDetails));
  }

  @Test
  void testUpdatePaymentDetails() {
    var id = 0L; // TODO fill id
    var input = new PaymentDetailsInput();
    // TODO fill input data
    assertTrue(paymentDetailsRepository.containsKey(id));
    var paymentDetails = customerUseCases.updatePaymentDetails(id, input);
    assertTrue(paymentDetails.isPresent());
    assertTrue(paymentDetailsRepository.containsEntity(paymentDetails.get()));
  }

  @Test
  void testListPaymentDetails() {
    var results = customerUseCases.listPaymentDetails(PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  void testGetPaymentDetails() {
    var id = 0L; // TODO fill id
    var paymentDetails = customerUseCases.getPaymentDetails(id);
    assertTrue(paymentDetails.isPresent());
  }

  @Test
  void testDeletePaymentDetails() {
    var id = 0L; // TODO fill id
    assertTrue(paymentDetailsRepository.containsKey(id));
    customerUseCases.deletePaymentDetails(id);
    assertFalse(paymentDetailsRepository.containsKey(id));
  }

  // ShippingDetails

  @Test
  void testCRUDShippingDetails() {
    var input = new ShippingDetailsInput();
    // TODO fill input data
    var shippingDetails = customerUseCases.createShippingDetails(input);
    assertNotNull(shippingDetails.getId());
    assertTrue(shippingDetailsRepository.containsEntity(shippingDetails));

    var id = shippingDetails.getId();
    var shippingDetailsUpdate = new ShippingDetailsInput();
    // TODO fill update data
    assertTrue(shippingDetailsRepository.containsKey(id));
    var shippingDetailsUpdated = customerUseCases.updateShippingDetails(id, shippingDetailsUpdate);
    assertTrue(shippingDetailsUpdated.isPresent());
    assertTrue(shippingDetailsRepository.containsEntity(shippingDetailsUpdated.get()));

    assertTrue(shippingDetailsRepository.containsKey(id));
    customerUseCases.deleteShippingDetails(id);
    assertFalse(shippingDetailsRepository.containsKey(id));
  }

  @Test
  void testCreateShippingDetails() {
    var input = new ShippingDetailsInput();
    // TODO fill input data
    var shippingDetails = customerUseCases.createShippingDetails(input);
    assertNotNull(shippingDetails.getId());
    assertTrue(shippingDetailsRepository.containsEntity(shippingDetails));
  }

  @Test
  void testUpdateShippingDetails() {
    var id = 0L; // TODO fill id
    var input = new ShippingDetailsInput();
    // TODO fill input data
    assertTrue(shippingDetailsRepository.containsKey(id));
    var shippingDetails = customerUseCases.updateShippingDetails(id, input);
    assertTrue(shippingDetails.isPresent());
    assertTrue(shippingDetailsRepository.containsEntity(shippingDetails.get()));
  }

  @Test
  void testListShippingDetails() {
    var results = customerUseCases.listShippingDetails(PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  void testGetShippingDetails() {
    var id = 0L; // TODO fill id
    var shippingDetails = customerUseCases.getShippingDetails(id);
    assertTrue(shippingDetails.isPresent());
  }

  @Test
  void testDeleteShippingDetails() {
    var id = 0L; // TODO fill id
    assertTrue(shippingDetailsRepository.containsKey(id));
    customerUseCases.deleteShippingDetails(id);
    assertFalse(shippingDetailsRepository.containsKey(id));
  }
}
