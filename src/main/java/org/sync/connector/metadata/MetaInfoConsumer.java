package org.sync.connector.metadata;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import test.DPPF.data_list.Envelope;

@Service
@Component
public class MetaInfoConsumer {
	@KafkaListener(topics = "test.DPPF.meta_info", groupId = "example-group", containerFactory = "kafkaListenerContainerFactory")
	public void listen(Envelope value) {
		System.out.println("Received Message: " );
	}
}
