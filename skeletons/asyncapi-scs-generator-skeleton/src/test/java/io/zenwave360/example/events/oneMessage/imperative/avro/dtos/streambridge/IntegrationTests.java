package io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge;

import io.zenwave360.example.adapters.events.avro.Customer;
import io.zenwave360.example.adapters.events.avro.CustomerEventPayload;
import io.zenwave360.example.adapters.events.avro.CustomerEventPayload2;
import io.zenwave360.example.adapters.events.avro.CustomerRequestPayload;
import io.zenwave360.example.adapters.events.avro.EventType;
import io.zenwave360.example.adapters.events.avro.RequestType;
import io.zenwave360.example.boot.Zenwave360ExampleApplication;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.client.ICustomerCommandsProducer;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.client.IOnCustomerEventAvroConsumerService;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.provider.ICustomerEventsProducer;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.provider.IDoCustomerRequestAvroConsumerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

@EmbeddedKafka
@SpringBootTest(classes = Zenwave360ExampleApplication.class)
@ContextConfiguration(classes = TestsConfiguration.class)
@DisplayName("Integration Tests: Imperative with avro dtos via streambridge")
@ActiveProfiles("avro")
public class IntegrationTests {

    private Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    ICustomerCommandsProducer customerCommandsProducer;
    @Autowired
    IDoCustomerRequestAvroConsumerService doCustomerRequestConsumerService;

    @Autowired
    ICustomerEventsProducer customerEventsProducer;
    @Autowired
    IOnCustomerEventAvroConsumerService onCustomerEventConsumerService;

    @Test
    void doCustomerCommandTest() throws InterruptedException {
        // Given
        var message = new CustomerRequestPayload();
        message.setId("123");
        message.setPayload(newCustomer());
        message.setRequestType(RequestType.create);
        var headers = new ICustomerCommandsProducer.CustomerRequestPayloadHeaders();
        // When
        customerCommandsProducer.doCustomerRequestAvro(message, headers);
        // Then
        var messages = awaitReceivedMessages(doCustomerRequestConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getId().toString(), ((CustomerRequestPayload) messages.get(0)).getId().toString());
    }

    @Test
    void onCustomerEventTest() throws InterruptedException {
        // Given
        var message = new CustomerEventPayload();
        message.setId("123");
        message.setPayload(newCustomer());
        message.setEventType(EventType.created);
        var headers = new ICustomerEventsProducer.CustomerEventPayloadHeaders();
        // Given
        customerEventsProducer.onCustomerEventAvro(message, headers);
        // Then
        var messages = awaitReceivedMessages(onCustomerEventConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getId().toString(), ((CustomerEventPayload) messages.get(0)).getId().toString());
    }

    @Test
    @Disabled
    void onCustomerEvent2Test() throws InterruptedException {
        // Given
        var message = new CustomerEventPayload2();
        message.setId("123");
        message.setPayload(newCustomer());
        message.setEventType(EventType.created);
        var headers = new ICustomerEventsProducer.CustomerEventPayload2Headers();
        // Given
        customerEventsProducer.onCustomerEventAvro(message, headers);
        // Then
        var messages = awaitReceivedMessages(onCustomerEventConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getId().toString(), ((CustomerEventPayload2) messages.get(0)).getId().toString());
    }

    private List awaitReceivedMessages(Object consumer) throws InterruptedException {
        await().atMost(5, SECONDS).until(() -> !getReceivedMessages(consumer).isEmpty());
        return getReceivedMessages(consumer);
    }

    private List getReceivedMessages(Object consumer) {
        return (List) ReflectionTestUtils.getField(consumer, "receivedMessages");
    }

    private Customer newCustomer() {
        var customer = new Customer();
        customer.setId("123");
        customer.setUsername("joe");
        customer.setPassword("123456");
        customer.setEmail("joe@example.com");
        customer.setFirstName("John");
        customer.setLastName("Doe");
        return customer;
    }
}