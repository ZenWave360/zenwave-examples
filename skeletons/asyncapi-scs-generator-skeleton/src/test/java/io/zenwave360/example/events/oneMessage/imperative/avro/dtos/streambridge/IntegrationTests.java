package io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge;

import io.zenwave360.example.adapters.events.avro.Customer;
import io.zenwave360.example.adapters.events.avro.EventType;
import io.zenwave360.example.adapters.events.avro.RequestType;
import io.zenwave360.example.boot.Zenwave360ExampleApplication;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.client.ICustomerCommandsProducer;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.client.IOnCustomerEventAvroConsumerService;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.provider.ICustomerEventsProducer;
import io.zenwave360.example.events.oneMessage.imperative.avro.dtos.streambridge.provider.IDoCustomerRequestAvroConsumerService;
import io.zenwave360.example.adapters.events.avro.CustomerEventPayload;
import io.zenwave360.example.adapters.events.avro.CustomerRequestPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Map;

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
        var message = new CustomerRequestPayload();
        message.setId("123");
        message.setPayload(newCustomer());
        message.setRequestType(RequestType.create);
        var headers = new ICustomerCommandsProducer.CustomerRequestPayloadHeaders();

        customerCommandsProducer.doCustomerRequestAvro(message, headers);
        var messages = awaitReceivedMessages(doCustomerRequestConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getId().toString(), ((CustomerRequestPayload) messages.get(0)).getId().toString());
    }

    @Test
    void onCustomerEventTest() throws InterruptedException {
        var message = new CustomerEventPayload();
        message.setId("123");
        message.setPayload(newCustomer());
        message.setEventType(EventType.created);
        var headers = new ICustomerEventsProducer.CustomerEventPayloadHeaders();
        customerEventsProducer.onCustomerEventAvro(message, headers);

        var messages = awaitReceivedMessages(onCustomerEventConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getId().toString(), ((CustomerEventPayload) messages.get(0)).getId().toString());
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
