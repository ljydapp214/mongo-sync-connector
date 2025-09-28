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
			.originalName(a.getOriginalName())
			.time(Long.parseLong(a.getTime()))
			.projectId(a.getProjectId())
			.subProjectId(a.getSubProjectId())
			.versionId(a.getVersionId())
			.sessionId(a.getSessionId())
			.available(a.getAvailable() == 1)
			.createdAt(LocalDateTime.ofEpochSecond(a.getCreatedAt(), 0, ZoneOffset.UTC))
			.updatedAt(LocalDateTime.ofEpochSecond(a.getUpdatedAt(), 0, ZoneOffset.UTC))
			.fleetDetailInfoId(a.getFleetDetailInfoId())
			.signalDefinitionId(a.getSignalDefinitionId())
			.tagId(a.getTagId())
			.signalFileType(a.getSignalFileType())
			.imageExisted(a.getImageExisted() == 1)
			.parquetExisted(a.getParquetExisted() == 1)
			.projectId(a.getProjectId())
			.build();
	}

	public Essential toClipWhenUpdating(Essential essential, Envelope source) {
		Value a = source.getAfter();
		return Essential.builder()
			.id(essential.getId())
			.clipId(a.getId())
			.name(a.getName())
			.originalName(a.getOriginalName())
			.time(Long.parseLong(a.getTime()))
			.projectId(a.getProjectId())
			.subProjectId(a.getSubProjectId())
			.versionId(a.getVersionId())
			.sessionId(a.getSessionId())
			.available(a.getAvailable() == 1)
			.collectedTime(a.getCollectedTime() != null
				? LocalDateTime.ofEpochSecond(a.getCollectedTime(), 0, ZoneOffset.UTC)
				: LocalDateTime.ofEpochSecond(Long.parseLong(a.getDriveStartTime()), 0, ZoneOffset.UTC))
			.createdAt(LocalDateTime.ofEpochSecond(a.getCreatedAt(), 0, ZoneOffset.UTC))
			.updatedAt(LocalDateTime.ofEpochSecond(a.getUpdatedAt(), 0, ZoneOffset.UTC))
			.driveStartTime(Long.parseLong(a.getDriveStartTime()))
			.fleetDetailInfoId(a.getFleetDetailInfoId())
			.signalDefinitionId(a.getSignalDefinitionId())
			.tagId(a.getTagId())
			.signalFileType(a.getSignalFileType())
			.imageExisted(a.getImageExisted() == 1)
			.parquetExisted(a.getParquetExisted() == 1)
			.projectId(a.getProjectId())
			.build();
	}
}
