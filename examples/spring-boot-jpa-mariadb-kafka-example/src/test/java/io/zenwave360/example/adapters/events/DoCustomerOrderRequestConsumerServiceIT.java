package io.zenwave360.example.adapters.events;

import io.zenwave360.example.adapters.events.IDoCustomerOrderRequestConsumerService.CustomerOrderRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IDoCustomerOrderRequestConsumerService}. */
public class DoCustomerOrderRequestConsumerServiceIT extends BaseConsumerTest {

  @Autowired public IDoCustomerOrderRequestConsumerService consumerService;

  /** Test for doCustomerOrderRequest: */
  @Test
  public void doCustomerOrderRequestTest() {
    CustomerOrderRequestPayload payload = new CustomerOrderRequestPayload();
    payload.setCustomerOrderId(null);
    payload.setRequestType(null);
    payload.setCustomerOrder(null);

    CustomerOrderRequestPayloadHeaders headers = new CustomerOrderRequestPayloadHeaders();

    // invoke the method under test
    consumerService.doCustomerOrderRequest(payload, headers);
    // perform your assertions here
  }
}
