package io.zenwave360.example.infrastructure.jpa;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.PaymentDetailsRepository;
import java.time.*;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentDetailsRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

  @Autowired EntityManager entityManager;

  @Autowired PaymentDetailsRepository paymentDetailsRepository;

  @Test
  public void findAllTest() {
    var results = paymentDetailsRepository.findAll();
    Assertions.assertFalse(results.isEmpty());
  }

  @Test
  public void findByIdTest() {
    var id = 1L;
    var paymentDetails = paymentDetailsRepository.findById(id).orElseThrow();
    Assertions.assertTrue(paymentDetails.getId() != null);
    Assertions.assertTrue(paymentDetails.getVersion() != null);
  }

  @Test
  public void saveTest() {
    PaymentDetails paymentDetails = new PaymentDetails();
    paymentDetails.setCardHolderName("");
    paymentDetails.setCreditCardNumber("");

    // ManyToOne customer owner: true
    var customerId = 1L;
    paymentDetails.setCustomerId(customerId); // using id to write relationship

    // Persist aggregate root
    var created = paymentDetailsRepository.save(paymentDetails);

    entityManager.refresh(created); // reloading to get relationships persisted by id
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);

    Assertions.assertTrue(paymentDetails.getCustomer().getId() == customerId);
  }

  @Test
  public void updateTest() {
    var id = 1L;
    var paymentDetails = paymentDetailsRepository.findById(id).orElseThrow();
    paymentDetails.setCardHolderName("");
    paymentDetails.setCreditCardNumber("");

    paymentDetails = paymentDetailsRepository.save(paymentDetails);
    Assertions.assertEquals("", paymentDetails.getCardHolderName());
    Assertions.assertEquals("", paymentDetails.getCreditCardNumber());
  }

  @Test
  public void deleteTest() {
    var id = 1L;
    paymentDetailsRepository.deleteById(id);
    var notFound = paymentDetailsRepository.findById(id);
    Assertions.assertFalse(notFound.isPresent());
  }
}
