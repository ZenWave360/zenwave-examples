package io.zenwave360.example.adapters.commands;

import io.zenwave360.example.adapters.commands.IDoCustomerOrderRequestConsumerService.CustomerOrderRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoCustomerOrderRequestConsumerServiceAdapter implements IDoCustomerOrderRequestConsumerService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  private AdapterEventsMapper mapper;
  // TODO: private EntityService service;

  @Autowired
  public void setAdapterEventsMapper(AdapterEventsMapper mapper) {
    this.mapper = mapper;
  }

  /** CustomerOrder Async Requests */
  public void doCustomerOrderRequest(CustomerOrderRequestPayload payload, CustomerOrderRequestPayloadHeaders headers) {
    logger.debug("Received command request for doCustomerRequest: {} with headers {}", payload, headers);
    // TODO: service.doCustomerOrderRequest(mapper.asEntity(payload));
  };
}
