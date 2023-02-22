package io.zenwave360.example.config;

import io.zenwave360.example.core.implementation.*;
import io.zenwave360.example.core.implementation.mappers.EventsMapper;
import io.zenwave360.example.core.outbound.events.ProducerInMemoryContext;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

  public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();

  public CustomerUseCasesImpl customerUseCases() {
    return new CustomerUseCasesImpl(null, customerRepository(), customerSearchRepository(), paymentDetailsRepository(), shippingDetailsRepository(), ProducerInMemoryContext.INSTANCE.customerEventsProducer());
  }

  public CustomerOrderUseCasesImpl customerOrderUseCases() {
    return new CustomerOrderUseCasesImpl(customerOrderRepository(), ProducerInMemoryContext.INSTANCE.customerOrderEventsProducer());
  }
}
