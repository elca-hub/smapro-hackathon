package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.repository.ICommunityRepository;
import com.mokimaki.arput.infrastructure.db.context.CommunityContext;
import com.mokimaki.arput.infrastructure.db.entity.CommunityEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityRepository implements ICommunityRepository {
    private final CommunityContext communityContext;

    public CommunityRepository(CommunityContext communityContext) {
        this.communityContext = communityContext;
    }

    @Override
    public void create(Community community) {
        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.convert(community);

        communityContext.save(communityEntity);
    }
}
