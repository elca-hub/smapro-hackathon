package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.ICommunityRepository;
import com.mokimaki.arput.infrastructure.db.context.CommunityContext;
import com.mokimaki.arput.infrastructure.db.context.JoinedCommunityContext;
import com.mokimaki.arput.infrastructure.db.context.UserContext;
import com.mokimaki.arput.infrastructure.db.entity.CommunityEntity;
import com.mokimaki.arput.infrastructure.db.entity.JoinedCommunityEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommunityRepository implements ICommunityRepository {
    private final CommunityContext communityContext;
    private final UserContext userContext;
    private final JoinedCommunityContext joinedCommunityContext;

    public CommunityRepository(CommunityContext communityContext, UserContext userContext, JoinedCommunityContext joinedCommunityContext) {
        this.communityContext = communityContext;
        this.userContext = userContext;
        this.joinedCommunityContext = joinedCommunityContext;
    }

    @Override
    public void create(UserId userId, Community community) {
        UserEntity user = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザーが存在しません"));

        CommunityEntity communityEntity = new CommunityEntity();
        communityEntity.convert(community);
        communityEntity.setOwner(user);

        communityContext.save(communityEntity);

        JoinedCommunityEntity joinedCommunityEntity = new JoinedCommunityEntity();
        joinedCommunityEntity.setCommunityEntity(communityEntity);
        joinedCommunityEntity.setUserEntity(user);

        joinedCommunityContext.save(joinedCommunityEntity);
    }

    @Override
    public List<Community> findOwnCommunities(UserId userId) {
        UserEntity user = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザーが存在しません"));

        return communityContext.findByOwner(user).stream().map(CommunityEntity::convert).toList();
    }

    @Override
    public List<Community> findByUserId(UserId userId) {
        UserEntity user = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザーが存在しません"));

        List<CommunityEntity> communityEntities = joinedCommunityContext.findByUserEntity(user).stream().map(JoinedCommunityEntity::getCommunityEntity).toList();

        return communityEntities.stream().map(CommunityEntity::convert).toList();
    }

    @Override
    public void update(Community community) {
        var communityEntity = new CommunityEntity();
        communityEntity.convert(community);

        communityContext.save(communityEntity);
    }

    @Override
    public Optional<Community> findById(String communityId) {
        return communityContext.findById(communityId).map(CommunityEntity::convert);
    }

    @Override
    public void delete(Community community) {
        var communityEntity = new CommunityEntity();
        communityEntity.convert(community);

        var joinedCommunityEntities = joinedCommunityContext.findByCommunityEntity(communityEntity);
        joinedCommunityContext.deleteAll(joinedCommunityEntities);

        communityContext.delete(communityEntity);
    }
}