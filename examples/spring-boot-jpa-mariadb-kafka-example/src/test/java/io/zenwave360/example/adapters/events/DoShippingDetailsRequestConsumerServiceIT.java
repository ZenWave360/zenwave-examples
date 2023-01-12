package io.zenwave360.example.adapters.events;

import io.zenwave360.example.adapters.events.IDoShippingDetailsRequestConsumerService.ShippingDetailsRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IDoShippingDetailsRequestConsumerService}. */
public class DoShippingDetailsRequestConsumerServiceIT extends BaseConsumerTest {

  @Autowired public IDoShippingDetailsRequestConsumerService consumerService;

  /** Test for doShippingDetailsRequest: */
  @Test
  public void doShippingDetailsRequestTest() {
    ShippingDetailsRequestPayload payload = new ShippingDetailsRequestPayload();
    payload.setShippingDetailsId(null);
    payload.setRequestType(null);
    payload.setShippingDetails(null);

    ShippingDetailsRequestPayloadHeaders headers = new ShippingDetailsRequestPayloadHeaders();

    // invoke the method under test
    consumerService.doShippingDetailsRequest(payload, headers);
    // perform your assertions here
  }
}
