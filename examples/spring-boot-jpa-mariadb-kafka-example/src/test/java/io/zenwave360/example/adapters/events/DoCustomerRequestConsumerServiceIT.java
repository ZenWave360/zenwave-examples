package io.zenwave360.example.adapters.events;

import io.zenwave360.example.adapters.events.IDoCustomerRequestConsumerService.CustomerRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IDoCustomerRequestConsumerService}. */
public class DoCustomerRequestConsumerServiceIT extends BaseConsumerTest {

  @Autowired public IDoCustomerRequestConsumerService consumerService;

  /** Test for doCustomerRequest: */
  @Test
  public void doCustomerRequestTest() {
    CustomerRequestPayload payload = new CustomerRequestPayload();
    payload.setCustomerId(null);
    payload.setRequestType(null);
    payload.setCustomer(null);

    CustomerRequestPayloadHeaders headers = new CustomerRequestPayloadHeaders();

    // invoke the method under test
    consumerService.doCustomerRequest(payload, headers);
    // perform your assertions here
  }
}
