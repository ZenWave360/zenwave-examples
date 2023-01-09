package io.zenwave360.example.config;

import io.zenwave360.example.core.events.provider.CustomerEventsProducerCaptor;
import io.zenwave360.example.core.events.provider.CustomerOrderEventsProducerCaptor;
import io.zenwave360.example.core.events.provider.ICustomerEventsProducer;
import io.zenwave360.example.core.events.provider.ICustomerOrderEventsProducer;

public class InMemoryEventsProducerContext {

    CustomerEventsProducerCaptor customerEventsProducerCaptor = new CustomerEventsProducerCaptor();
    <T extends ICustomerEventsProducer> T customerEventsProducer() {
        return (T) customerEventsProducerCaptor;
    }

    CustomerOrderEventsProducerCaptor customerOrderEventsProducerCaptor = new CustomerOrderEventsProducerCaptor();
    <T extends ICustomerOrderEventsProducer> T customerOrderEventsProducer() {
        return (T) customerOrderEventsProducerCaptor;
    }
}
