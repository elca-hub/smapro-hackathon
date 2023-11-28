package com.mokimaki.arput.domain.repository;

import com.mokimaki.arput.domain.model.community.Community;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommunityRepository {
    void create(Community community);
}
