package io.zenwave360.example.infrastructure.jpa;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.ShippingDetailsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShippingDetailsRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

  @Autowired ShippingDetailsRepository shippingDetailsRepository;

  @Test
  public void findAllTest() {
    var results = shippingDetailsRepository.findAll();
    Assertions.assertFalse(results.isEmpty());
  }

  @Test
  public void findByIdTest() {
    var id = 1L;
    var shippingDetails = shippingDetailsRepository.findById(id).orElseThrow();
    Assertions.assertTrue(shippingDetails.getId() != null);
    Assertions.assertTrue(shippingDetails.getVersion() != null);
  }

  @Test
  public void saveTest() {
    ShippingDetails shippingDetails = new ShippingDetails();
    shippingDetails.setPhone(null);
    shippingDetails.setAddress(null);

    var created = shippingDetailsRepository.save(shippingDetails);
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);
  }

  @Test
  public void updateTest() {
    var id = 1L;
    var shippingDetails = shippingDetailsRepository.findById(id).orElseThrow();
    shippingDetails.setPhone(null);
    shippingDetails.setAddress(null);

    shippingDetails = shippingDetailsRepository.save(shippingDetails);
    Assertions.assertEquals("", shippingDetails.getPhone());
    Assertions.assertEquals("", shippingDetails.getAddress());
  }

  @Test
  public void deleteTest() {
    var id = 1L;
    shippingDetailsRepository.deleteById(id);
    var notFound = shippingDetailsRepository.findById(id);
    Assertions.assertFalse(notFound.isPresent());
  }
}
