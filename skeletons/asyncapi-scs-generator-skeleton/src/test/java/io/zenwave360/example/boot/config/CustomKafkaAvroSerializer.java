package io.zenwave360.example.boot.config;

import io.confluent.kafka.schemaregistry.client.MockSchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;

import java.util.Map;

public class CustomKafkaAvroSerializer extends KafkaAvroSerializer {
    public CustomKafkaAvroSerializer() {
        super();
        super.schemaRegistry = new MockSchemaRegistryClient();
    }

    public CustomKafkaAvroSerializer(SchemaRegistryClient client) {
        super(new MockSchemaRegistryClient());
    }

    public CustomKafkaAvroSerializer(SchemaRegistryClient client, Map<String, ?> props) {
        super(new MockSchemaRegistryClient(), props);
    }
}
