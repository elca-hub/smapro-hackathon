package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleContext extends CrudRepository<ArticleEntity, String> {
}
