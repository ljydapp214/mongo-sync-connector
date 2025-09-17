package org.sync.connector.consumer;

import java.util.Map;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import test.DPPF.data_list.Envelope;

@Configuration
public class KafkaConsumerConfig {
	@Bean
	public ConsumerFactory<String, Envelope> consumerFactory() {
		Map<String, Object> props = new java.util.HashMap<>(Map.of(
			ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "",
			ConsumerConfig.GROUP_ID_CONFIG, "example-group",
			ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class,
			ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class,
			"schema.registry.url", "",
			CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_SSL",
			SaslConfigs.SASL_JAAS_CONFIG,
			"org.apache.kafka.common.security.plain.PlainLoginModule required';",
			SaslConfigs.SASL_MECHANISM, "PLAIN",
			KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true,
			AbstractKafkaSchemaSerDeConfig.BASIC_AUTH_CREDENTIALS_SOURCE, "USER_INFO"
		));

		props.
			put(AbstractKafkaSchemaSerDeConfig.USER_INFO_CONFIG, "");

		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Envelope> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Envelope> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
