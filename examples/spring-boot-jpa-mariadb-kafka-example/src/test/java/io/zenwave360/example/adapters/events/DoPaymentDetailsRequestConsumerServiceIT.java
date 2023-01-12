package io.zenwave360.example.adapters.events;

import io.zenwave360.example.adapters.events.IDoPaymentDetailsRequestConsumerService.PaymentDetailsRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/** Integration tests for {@link IDoPaymentDetailsRequestConsumerService}. */
public class DoPaymentDetailsRequestConsumerServiceIT extends BaseConsumerTest {

  @Autowired public IDoPaymentDetailsRequestConsumerService consumerService;

  /** Test for doPaymentDetailsRequest: */
  @Test
  public void doPaymentDetailsRequestTest() {
    PaymentDetailsRequestPayload payload = new PaymentDetailsRequestPayload();
    payload.setPaymentDetailsId(null);
    payload.setRequestType(null);
    payload.setPaymentDetails(null);

    PaymentDetailsRequestPayloadHeaders headers = new PaymentDetailsRequestPayloadHeaders();

    // invoke the method under test
    consumerService.doPaymentDetailsRequest(payload, headers);
    // perform your assertions here
  }
}
