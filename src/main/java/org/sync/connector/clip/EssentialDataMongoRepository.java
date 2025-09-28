package org.sync.connector.clip;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EssentialDataMongoRepository extends MongoRepository<Essential, String> {
	void deleteByClipId(long clipId);

	Essential findByClipId(long clipId);
}
