package io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge;

import io.zenwave360.example.boot.Zenwave360ExampleApplication;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.client.ICustomerCommandsProducer;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.client.IOnCustomerEventConsumerService;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.provider.ICustomerEventsProducer;
import io.zenwave360.example.events.oneMessage.imperative.json.dtos.streambridge.provider.IDoCustomerRequestConsumerService;
import io.zenwave360.example.events.oneMessage.model.CustomerEventPayload;
import io.zenwave360.example.events.oneMessage.model.CustomerRequestPayload;
import org.junit.ClassRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

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

    @Test
    void doCustomerCommandTest() throws InterruptedException {
        var message = new CustomerRequestPayload().withCustomerId("231");
        var headers = new ICustomerCommandsProducer.CustomerRequestPayloadHeaders()
                .entityId("231")
                .commonHeader("value")
                .set("undocumented", "value");

        customerCommandsProducer.doCustomerRequest(message, headers);
        var messages = awaitReceivedMessages(doCustomerRequestConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getCustomerId(), ((CustomerRequestPayload) messages.get(0)).getCustomerId());

        var receivedHeaders = getReceivedHeaders(doCustomerRequestConsumerService);
        Assertions.assertEquals("231", receivedHeaders.get(0).get("entity-id"));
        Assertions.assertEquals("value", receivedHeaders.get(0).get("undocumented"));
    }

    @Test
    void onCustomerEventTest() throws InterruptedException {
        var message = new CustomerEventPayload().withCustomerId("123");
        var headers = new ICustomerEventsProducer.CustomerEventPayloadHeaders()
                .entityId("123")
                .commonHeader("value")
                .set("undocumented", "value");
        customerEventsProducer.onCustomerEvent(message, headers);

        var messages = awaitReceivedMessages(onCustomerEventConsumerService);
        Assertions.assertEquals(1, messages.size());
        Assertions.assertEquals(message.getCustomerId(), ((CustomerEventPayload) messages.get(0)).getCustomerId());

        var receivedHeaders = getReceivedHeaders(onCustomerEventConsumerService);
        Assertions.assertEquals("123", receivedHeaders.get(0).get("entity-id"));
        Assertions.assertEquals("value", receivedHeaders.get(0).get("undocumented"));
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
}
