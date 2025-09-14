package org.sync.connector.consumer;

import java.beans.BeanProperty;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

public class KafkaConsumerConfig {
	@Bean
	public ConsumerFactory<String, Object> consumerFactory() {
		Map<String, Object> props = Map.of(
				"bootstrap.servers", "localhost:9092",
				"group.id", "example-group",
				"key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer",
				"value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"
		);

		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(ConsumerFactory<String, Object > consumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		return factory;
	}
}
