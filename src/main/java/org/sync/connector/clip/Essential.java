package org.sync.connector.clip;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "clip")
@Getter
@NoArgsConstructor
public class Essential {
	@Id
	private String id;
	private long clipId;
	private String name;
	private long firstCategory;
	private long secondCategory;
	private long thirdCategory;
	private LocalDateTime dataCollectedTime;
	private boolean available;
	private Map<String, Object> metaData;
	private Map<String, Map<String, List<Long>>> events;

	@Builder
	public Essential(
		String id,
		long clipId,
		String name,
		long firstCategory,
		long secondCategory,
		long thirdCategory,
		LocalDateTime dataCollectedTime,
		boolean available,
		Map<String, Object> metaData,
		Map<String, Map<String, List<Long>>> events
	) {
		this.id = id;
		this.clipId = clipId;
		this.name = name;
		this.firstCategory = firstCategory;
		this.secondCategory = secondCategory;
		this.thirdCategory = thirdCategory;
		this.dataCollectedTime = dataCollectedTime;
		this.available = available;
		this.metaData = metaData;
		this.events = events;
	}
}
