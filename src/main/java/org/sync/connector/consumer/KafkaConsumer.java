package org.sync.connector.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class KafkaConsumer {
	@KafkaListener(topics = "dbhistory.test.lcc-83q857", groupId = "example-group")
	public void listen(String message) {
		System.out.println("Received Message: " + message);
	}
}
