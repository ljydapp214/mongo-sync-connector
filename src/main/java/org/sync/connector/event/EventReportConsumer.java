package org.sync.connector.event;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import test.DPPF.data_list.Envelope;

@Service
@Component
public class EventReportConsumer {
	@KafkaListener(topics = "test.DPPF.event_report", groupId = "example-group", containerFactory = "kafkaListenerContainerFactory")
	public void listen(Envelope value) {
		System.out.println("Received Message: " );
	}
}
