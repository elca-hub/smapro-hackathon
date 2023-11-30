package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.CommunityEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleContext extends CrudRepository<ArticleEntity, String> {
    Optional<ArticleEntity> findByIdAndWriter(String id, UserEntity writer);

    List<ArticleEntity> findByWriter(UserEntity writer);

    List<ArticleEntity> findByCommunity(CommunityEntity communityEntity);
}
