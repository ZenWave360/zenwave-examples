package io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge;

import io.zenwave360.example.boot.Zenwave360ExampleApplication;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.client.ICustomerCommandsProducer;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.client.IOnCustomerEventConsumerService;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.provider.ICustomerEventsProducer;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.provider.IDoCustomerRequestConsumerService;
import io.zenwave360.example.events.oneMessage.model.CustomerEventPayload;
import io.zenwave360.example.events.oneMessage.model.CustomerRequestPayload;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

@EmbeddedKafka
@SpringBootTest(classes = Zenwave360ExampleApplication.class)
@ContextConfiguration(classes = TestsConfiguration.class)
@DisplayName("Integration Tests: Imperative with json dtos via streambridge")
public class IntegrationTests {

    private Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    ICustomerCommandsProducer customerCommandsProducer;
    @Autowired
    IDoCustomerRequestConsumerService doCustomerRequestConsumerService;

    @Autowired
    ICustomerEventsProducer customerEventsProducer;
    @Autowired
    IOnCustomerEventConsumerService onCustomerEventConsumerService;
    @Autowired @Qualifier("on-customer-event-error")
    Object onCustomerEventErrorHandler;

    @Autowired @Qualifier("on-customer-event-validation-error")
    Object onCustomerEventValidationErrorHandler;

    @Test
    void doCustomerCommandTest() throws InterruptedException {
        // Given
        var message = new CustomerRequestPayload().withCustomerId("231").withRequestType(CustomerRequestPayload.RequestType.CREATE);
        var headers = new ICustomerCommandsProducer.CustomerRequestPayloadHeaders()
                .entityId("231")
                .commonHeader("value")
                .set("undocumented", "value");
        // When
        customerCommandsProducer.doCustomerRequest(message, headers);
        // Then
        var messages = awaitReceivedMessages(doCustomerRequestConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getCustomerId(), ((CustomerRequestPayload) messages.get(0)).getCustomerId());

        var receivedHeaders = getReceivedHeaders(doCustomerRequestConsumerService);
        Assertions.assertEquals("231", receivedHeaders.get(0).get("entity-id"));
        Assertions.assertEquals("value", receivedHeaders.get(0).get("undocumented"));
    }

    @Test
    void onCustomerEventTest() throws InterruptedException {
        // Given
        var message = new CustomerEventPayload().withCustomerId("123").withEventType(CustomerEventPayload.EventType.CREATED);
        var headers = new ICustomerEventsProducer.CustomerEventPayloadHeaders()
                .entityId("123")
                .commonHeader("value")
                .set("undocumented", "value");
        // When
        customerEventsProducer.onCustomerEvent(message, headers);
        // Then
        var messages = awaitReceivedMessages(onCustomerEventConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getCustomerId(), ((CustomerEventPayload) messages.get(0)).getCustomerId());

        var receivedHeaders = getReceivedHeaders(onCustomerEventConsumerService);
        Assertions.assertEquals("123", receivedHeaders.get(0).get("entity-id"));
        Assertions.assertEquals("value", receivedHeaders.get(0).get("undocumented"));
    }

    @Test
    void onCustomerEventDefaultDeadLetterQueueTest() throws InterruptedException {
        // Given
        var message = new CustomerEventPayload()
                .withCustomerId("123")
                .withEventType(null); // will throw NullPointerException
        var headers = new ICustomerEventsProducer.CustomerEventPayloadHeaders();
        // When
        customerEventsProducer.onCustomerEvent(message, headers);
        // Then
        var messages = awaitReceivedMessages(onCustomerEventErrorHandler);
        Assertions.assertEquals(1, messages.size());
//        Assertions.assertEquals(message.getCustomerId(), ((CustomerEventPayload) messages.get(0)).getCustomerId());

        var receivedHeaders = getReceivedHeaders(onCustomerEventErrorHandler);
        Assertions.assertEquals(NullPointerException.class.getName(), receivedHeaders.get(0).get("x-exception-type"));
    }

    @Test
    void onCustomerEventCustomDeadLetterQueueTest() throws InterruptedException {
        // Given
        var message = new CustomerEventPayload()
                .withCustomerId(null) // will throw validation error
                .withEventType(CustomerEventPayload.EventType.UPDATED);
        var headers = new ICustomerEventsProducer.CustomerEventPayloadHeaders();
        // When
        customerEventsProducer.onCustomerEvent(message, headers);
        // Then
        var messages = awaitReceivedMessages(onCustomerEventValidationErrorHandler);
        Assertions.assertEquals(1, messages.size());
//        Assertions.assertEquals(message.getCustomerId(), ((CustomerEventPayload) messages.get(0)).getCustomerId());

        var receivedHeaders = getReceivedHeaders(onCustomerEventValidationErrorHandler);
        Assertions.assertEquals("customerId is null", receivedHeaders.get(0).get("x-exception-message"));
    }


    private List awaitReceivedMessages(Object consumer) throws InterruptedException {
        await().atMost(5, SECONDS).until(() -> !getReceivedMessages(consumer).isEmpty());
        return getReceivedMessages(consumer);
    }

    private List getReceivedMessages(Object consumer) {
        return (List) ReflectionTestUtils.getField(consumer, "receivedMessages");
    }
    private List<Map> getReceivedHeaders(Object consumer) {
        return (List) ReflectionTestUtils.getField(consumer, "receivedHeaders");
    }


    @TestConfiguration
    class TestsConfiguration {

        private Logger log = LoggerFactory.getLogger(io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.TestsConfiguration.class);

        @Bean
        public IOnCustomerEventConsumerService onCustomerEventConsumerService() {
            return new IOnCustomerEventConsumerService() {
                public List receivedMessages = new ArrayList();
                public List receivedHeaders = new ArrayList();
                @Override
                public void onCustomerEvent(CustomerEventPayload payload, CustomerEventPayloadHeaders headers) {
                    log.info("Received '{}' message with payload: {}", payload.getClass(), payload);
                    receivedMessages.add(payload);
                    receivedHeaders.add(headers);
                }
            };
        }

        @Bean
        public IDoCustomerRequestConsumerService doCustomerRequestConsumerService() {
            return new IDoCustomerRequestConsumerService() {
                public List receivedMessages = new ArrayList();
                public List receivedHeaders = new ArrayList();
                @Override
                public void doCustomerRequest(CustomerRequestPayload payload, CustomerRequestPayloadHeaders headers) {
                    log.info("Received '{}' message with payload: {}", payload.getClass(), payload);
                    receivedMessages.add(payload);
                    receivedHeaders.add(headers);
                }
            };
        }
    }
}
