package io.zenwave360.example.adapters.commands;

import io.zenwave360.example.adapters.commands.IDoCustomerOrderRequestConsumerService.CustomerOrderRequestPayloadHeaders;
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
    payload.setId(null);
    payload.setRequestType(CustomerOrderRequestPayload.RequestType.CREATE);
    payload.setCustomerOrder(new CustomerOrder());

    CustomerOrderRequestPayloadHeaders headers = new CustomerOrderRequestPayloadHeaders();

    // invoke the method under test
    consumerService.doCustomerOrderRequest(payload, headers);
    // perform your assertions here
  }
}
