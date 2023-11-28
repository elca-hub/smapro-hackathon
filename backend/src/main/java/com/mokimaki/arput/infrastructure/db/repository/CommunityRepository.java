package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.ICommunityRepository;
import com.mokimaki.arput.infrastructure.db.context.CommunityContext;
import com.mokimaki.arput.infrastructure.db.context.UserContext;
import com.mokimaki.arput.infrastructure.db.entity.CommunityEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CommunityRepository implements ICommunityRepository {
    private final CommunityContext communityContext;
    private final UserContext userContext;

    public CommunityRepository(CommunityContext communityContext, UserContext userContext) {
        this.communityContext = communityContext;
        this.userContext = userContext;
    }

    @Override
    public void create(UserId userId, Community community) {
        UserEntity user = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザーが存在しません"));

        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.convert(community);
        communityEntity.setOwner(user);

        communityContext.save(communityEntity);
    }
}
