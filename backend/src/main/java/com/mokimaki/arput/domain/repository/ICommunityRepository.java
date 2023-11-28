package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.UserId;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommunityRepository {
    void create(UserId userId, Community community);
}
