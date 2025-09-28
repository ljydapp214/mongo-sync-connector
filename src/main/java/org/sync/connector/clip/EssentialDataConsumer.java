package org.sync.connector.clip;

import java.util.Objects;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import test.DPPF.data_list.Envelope;

@Component
@RequiredArgsConstructor
public class EssentialDataConsumer {
	private final EssentialDataRepository essentialDataRepository;
	private final EssentialDataMapper essentialDataMapper;

	@KafkaListener(topics = "test.DPPF.data_list", groupId = "example-group", containerFactory = "kafkaListenerContainerFactory")
	public void listen(Envelope value) {
		if (value.getOp() == null) {
			throw new IllegalArgumentException();
		}

		if (Objects.equals(value.getOp(), "c")) {
			Essential essential = essentialDataMapper.toClipWhenCreating(value);
			essentialDataRepository.save(essential);
		} else if (Objects.equals(value.getOp(), "u")) {
			Essential essential = essentialDataRepository.findByClipId(value.getAfter().getId());
			Essential updated = essentialDataMapper.toClipWhenUpdating(essential, value);
			essentialDataRepository.save(updated);
		} else if (Objects.equals(value.getOp(), "d")) {
			essentialDataRepository.deleteById(value.getAfter().getId());
		}
	}
}
