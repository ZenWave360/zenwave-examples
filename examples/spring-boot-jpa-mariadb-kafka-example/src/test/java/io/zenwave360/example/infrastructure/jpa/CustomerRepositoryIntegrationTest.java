package io.zenwave360.example.infrastructure.jpa;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.CustomerRepository;
import java.time.*;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

  @Autowired EntityManager entityManager;

  @Autowired CustomerRepository customerRepository;

  @Test
  public void findAllTest() {
    var results = customerRepository.findAll();
    Assertions.assertFalse(results.isEmpty());
  }

  @Test
  public void findByIdTest() {
    var id = 1L;
    var customer = customerRepository.findById(id).orElseThrow();
    Assertions.assertTrue(customer.getId() != null);
    Assertions.assertTrue(customer.getVersion() != null);
    Assertions.assertTrue(customer.getCreatedBy() != null);
    Assertions.assertTrue(customer.getCreatedDate() != null);
  }

  @Test
  public void saveTest() {
    Customer customer = new Customer();
    customer.setFirstName("aaa");
    customer.setLastName("aaa");
    customer.setPassword("aaa");
    customer.setEmail("aaa");
    customer.setUsername("aaa");

    // ManyToOne shipmentDetails owner: false

    // ManyToOne paymentDetails owner: false

    // Persist aggregate root
    var created = customerRepository.save(customer);

    entityManager.refresh(created); // reloading to get relationships persisted by id
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);
    Assertions.assertTrue(created.getCreatedBy() != null);
    Assertions.assertTrue(created.getCreatedDate() != null);
  }

  @Test
  public void updateTest() {
    var id = 1L;
    var customer = customerRepository.findById(id).orElseThrow();
    customer.setFirstName("aaa");
    customer.setLastName("aaa");
    customer.setPassword("aaa");
    customer.setEmail("aaa");
    customer.setUsername("aaa");

    customer = customerRepository.save(customer);
    Assertions.assertEquals("aaa", customer.getFirstName());
    Assertions.assertEquals("aaa", customer.getLastName());
    Assertions.assertEquals("aaa", customer.getPassword());
    Assertions.assertEquals("aaa", customer.getEmail());
    Assertions.assertEquals("aaa", customer.getUsername());
  }

  @Test
  public void deleteTest() {
    var id = 1L;
    customerRepository.deleteById(id);
    var notFound = customerRepository.findById(id);
    Assertions.assertFalse(notFound.isPresent());
  }
}
