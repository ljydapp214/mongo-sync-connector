package org.sync.connector.clip;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

import test.DPPF.data_list.Envelope;
import test.DPPF.data_list.Value;

@Component
public class EssentialDataMapper {
	public Essential toClipWhenCreating(test.DPPF.data_list.Envelope source) {
		Value a = source.getAfter();
		return Essential.builder()
			.clipId(a.getId())
			.name(a.getName())
			.firstCategory(a.getProjectId())
			.secondCategory(a.getSubProjectId())
			.thirdCategory(a.getVersionId())
			.available(a.getAvailable() == 1)
			.dataCollectedTime(a.getCollectedTime() != null
				? LocalDateTime.ofEpochSecond(a.getCollectedTime(), 0, ZoneOffset.UTC)
				: LocalDateTime.ofEpochSecond(Long.parseLong(a.getDriveStartTime()), 0, ZoneOffset.UTC))
			.build();
	}

	public Essential toClipWhenUpdating(Essential essential, Envelope source) {
		Value a = source.getAfter();
		return Essential.builder()
			.id(essential.getId())
			.clipId(a.getId())
			.name(a.getName())
			.firstCategory(a.getProjectId())
			.secondCategory(a.getSubProjectId())
			.thirdCategory(a.getVersionId())
			.available(a.getAvailable() == 1)
			.dataCollectedTime(a.getCollectedTime() != null
				? LocalDateTime.ofEpochSecond(a.getCollectedTime(), 0, ZoneOffset.UTC)
				: LocalDateTime.ofEpochSecond(Long.parseLong(a.getDriveStartTime()), 0, ZoneOffset.UTC))
			.build();
	}
}
