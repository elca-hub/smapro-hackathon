package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.CommunityEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommunityContext extends CrudRepository<CommunityEntity, String> {
    List<CommunityEntity> findByOwner(UserEntity owner);

    Optional<CommunityEntity> findByEntryCode(String entryCode);
}
