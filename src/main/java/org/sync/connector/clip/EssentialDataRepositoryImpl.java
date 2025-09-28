package org.sync.connector.clip;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EssentialDataRepositoryImpl implements EssentialDataRepository {
	private final EssentialDataMongoRepository essentialDataMongoRepository;

	@Override
	public void save(Essential essential) {
		essentialDataMongoRepository.insert(essential);
	}

	@Override
	public void deleteById(long clipId) {
		essentialDataMongoRepository.deleteByClipId(clipId);
	}

	@Override
	public Essential findByClipId(long clipId) {
		return essentialDataMongoRepository.findByClipId(clipId);
	}
}
