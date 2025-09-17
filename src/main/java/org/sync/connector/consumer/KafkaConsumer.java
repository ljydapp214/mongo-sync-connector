package org.sync.connector.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import test.DPPF.data_list.Envelope;

@Service
@Component
public class KafkaConsumer {
	@KafkaListener(topics = "test.DPPF.data_list", groupId = "example-group", containerFactory = "kafkaListenerContainerFactory")
	public void listen(Envelope value) {
		System.out.println("Received Message: " );
	}
}
