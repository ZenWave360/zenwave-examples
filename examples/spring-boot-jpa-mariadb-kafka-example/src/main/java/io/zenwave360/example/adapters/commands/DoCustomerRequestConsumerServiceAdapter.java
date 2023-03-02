package io.zenwave360.example.adapters.commands;

import io.zenwave360.example.adapters.commands.IDoCustomerRequestConsumerService.CustomerRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import io.zenwave360.example.core.inbound.CustomerUseCases;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoCustomerRequestConsumerServiceAdapter implements IDoCustomerRequestConsumerService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  private AdapterEventsMapper mapper;
  CustomerUseCases service;

  @Autowired
  public void setAdapterEventsMapper(AdapterEventsMapper mapper) {
    this.mapper = mapper;
  }

  /** Customer Async Requests */
  public void doCustomerRequest(CustomerRequestPayload payload, CustomerRequestPayloadHeaders headers) {
    logger.debug("Received command request for doCustomerRequest: {} with headers {}", payload, headers);

  };
}
