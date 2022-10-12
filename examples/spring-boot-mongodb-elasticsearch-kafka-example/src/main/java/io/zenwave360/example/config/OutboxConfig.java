package io.zenwave360.example.config;

import io.zenwave360.example.core.events.provider.CustomerEventsProducer;
import io.zenwave360.example.core.events.provider.CustomerOrderEventsProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.messaging.ChangeStreamRequest;
import org.springframework.data.mongodb.core.messaging.ChangeStreamRequest.ChangeStreamRequestOptions;
import org.springframework.data.mongodb.core.messaging.DefaultMessageListenerContainer;
import org.springframework.data.mongodb.core.messaging.MessageListenerContainer;

import java.util.Map;

@Configuration
public class OutboxConfig {

//    @Bean(destroyMethod = "stop")
//    public MessageListenerContainer configCustomerEventOutboxCollectionChangeStreams(MongoTemplate template, CustomerEventsProducer customerEventsProducer) {
//        var changeStreamOptions = ChangeStreamOptions.builder();
//        var resumeToken = customerEventsProducer.getOnCustomerEventResumeToken();
//        if(resumeToken != null) {
//            changeStreamOptions.resumeAfter(resumeToken);
//        }
//
//        customerEventsProducer.skipMessagesBeforePersistingResumeToken = 0;
//
//        final var container = new DefaultMessageListenerContainer(template);
//        final var options = new ChangeStreamRequestOptions(null, customerEventsProducer.onCustomerEventOutboxCollection, changeStreamOptions.build());
//        container.register(new ChangeStreamRequest<>(customerEventsProducer.onCustomerEventMongoChangeStreamsListener, options), Map.class);
//        container.start();
//        return container;
//    }
//
//    @Bean(destroyMethod = "stop")
//    public MessageListenerContainer configCustomerOrderEventOutboxCollectionChangeStreams(MongoTemplate template, CustomerOrderEventsProducer customerOrderEventsProducer) {
//        var changeStreamOptions = ChangeStreamOptions.builder();
//        var resumeToken = customerOrderEventsProducer.getOnCustomerOrderEventResumeToken();
//        if(resumeToken != null) {
//            changeStreamOptions.resumeAfter(resumeToken);
//        }
//
//        customerOrderEventsProducer.skipMessagesBeforePersistingResumeToken = 0;
//
//        MessageListenerContainer container = new DefaultMessageListenerContainer(template);
//        ChangeStreamRequestOptions options = new ChangeStreamRequestOptions(null, customerOrderEventsProducer.onCustomerOrderEventOutboxCollection, changeStreamOptions.build());
//        container.register(new ChangeStreamRequest<>(customerOrderEventsProducer.onCustomerOrderEventMongoChangeStreamsListener, options), Map.class);
//        container.start();
//        return container;
//    }
}
