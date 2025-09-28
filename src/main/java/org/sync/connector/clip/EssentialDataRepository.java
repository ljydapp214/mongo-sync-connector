package org.sync.connector.clip;

public interface EssentialDataRepository {
	void save(Essential essential);

	void deleteById(long clipId);

	Essential findByClipId(long clipId);
}
