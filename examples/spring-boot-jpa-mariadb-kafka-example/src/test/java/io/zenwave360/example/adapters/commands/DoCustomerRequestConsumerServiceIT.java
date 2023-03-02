package io.zenwave360.example.adapters.commands;

import io.zenwave360.example.adapters.commands.IDoCustomerRequestConsumerService.CustomerRequestPayloadHeaders;
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
    payload.setId(null);
    payload.setRequestType(CustomerRequestPayload.RequestType.CREATE);
    payload.setCustomer(new Customer().withUsername("username"));

    CustomerRequestPayloadHeaders headers = new CustomerRequestPayloadHeaders();

    // invoke the method under test
    consumerService.doCustomerRequest(payload, headers);
    // perform your assertions here
  }
}
