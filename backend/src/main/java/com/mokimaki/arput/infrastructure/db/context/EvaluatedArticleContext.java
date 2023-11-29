package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.EvaluatedArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface EvaluatedArticleContext extends CrudRepository<EvaluatedArticleEntity, Integer> {
}
