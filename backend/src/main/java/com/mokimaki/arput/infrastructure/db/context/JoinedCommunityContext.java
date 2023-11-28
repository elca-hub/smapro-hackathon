package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.CommunityEntity;
import com.mokimaki.arput.infrastructure.db.entity.JoinedCommunityEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JoinedCommunityContext extends CrudRepository<JoinedCommunityEntity, Integer> {
    List<JoinedCommunityEntity> findByUser(UserEntity user);

    List<JoinedCommunityEntity> findByCommunity(CommunityEntity community);
}
