package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticleContext extends CrudRepository<ArticleEntity, String> {
    Optional<ArticleEntity> findByIdAndWriter(String id, UserEntity writer);
}
