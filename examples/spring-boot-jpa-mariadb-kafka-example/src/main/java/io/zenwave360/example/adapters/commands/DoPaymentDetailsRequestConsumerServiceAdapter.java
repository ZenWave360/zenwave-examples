package io.zenwave360.example.adapters.commands;

import io.zenwave360.example.adapters.commands.IDoPaymentDetailsRequestConsumerService.PaymentDetailsRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoPaymentDetailsRequestConsumerServiceAdapter implements IDoPaymentDetailsRequestConsumerService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  private AdapterEventsMapper mapper;
  // TODO: private EntityService service;

  @Autowired
  public void setAdapterEventsMapper(AdapterEventsMapper mapper) {
    this.mapper = mapper;
  }

  /** PaymentDetails Async Requests */
  public void doPaymentDetailsRequest(PaymentDetailsRequestPayload payload, PaymentDetailsRequestPayloadHeaders headers) {
    logger.debug("Received command request for doCustomerRequest: {} with headers {}", payload, headers);
    // TODO: service.doPaymentDetailsRequest(mapper.asEntity(payload));
  };
}
