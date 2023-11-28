package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.UserId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICommunityRepository {
    void create(UserId userId, Community community);

    Optional<Community> findById(String communityId);

    List<Community> findOwnCommunities(UserId userId);

    List<Community> findByUserId(UserId userId);

    void update(Community community);
}
