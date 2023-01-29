package io.zenwave360.example.adapters.commands;

import io.zenwave360.example.adapters.commands.IDoShippingDetailsRequestConsumerService.ShippingDetailsRequestPayloadHeaders;
import io.zenwave360.example.core.domain.events.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoShippingDetailsRequestConsumerServiceAdapter implements IDoShippingDetailsRequestConsumerService {

  private Logger logger = LoggerFactory.getLogger(getClass());

  private AdapterEventsMapper mapper;
  // TODO: private EntityService service;

  @Autowired
  public void setAdapterEventsMapper(AdapterEventsMapper mapper) {
    this.mapper = mapper;
  }

  /** ShippingDetails Async Requests */
  public void doShippingDetailsRequest(ShippingDetailsRequestPayload payload, ShippingDetailsRequestPayloadHeaders headers) {
    logger.debug("Received command request for doCustomerRequest: {} with headers {}", payload, headers);
    // TODO: service.doShippingDetailsRequest(mapper.asEntity(payload));
  };
}
