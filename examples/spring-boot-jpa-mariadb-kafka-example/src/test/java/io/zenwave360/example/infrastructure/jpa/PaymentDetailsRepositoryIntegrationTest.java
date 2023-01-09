package io.zenwave360.example.infrastructure.jpa;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.PaymentDetailsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PaymentDetailsRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

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
    paymentDetails.setCardHolderName(null);
    paymentDetails.setCreditCardNumber(null);

    var created = paymentDetailsRepository.save(paymentDetails);
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);
  }

  @Test
  public void updateTest() {
    var id = 1L;
    var paymentDetails = paymentDetailsRepository.findById(id).orElseThrow();
    paymentDetails.setCardHolderName(null);
    paymentDetails.setCreditCardNumber(null);

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
