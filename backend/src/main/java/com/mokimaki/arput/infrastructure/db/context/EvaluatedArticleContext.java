package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.EvaluatedArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EvaluatedArticleContext extends JpaRepository<EvaluatedArticleEntity, Integer> {
    @Query("SELECT e.evaluation, COUNT(e) FROM EvaluatedArticleEntity e WHERE e.article = ?1 GROUP BY e.evaluation")
    Object[][] countEvaluation(ArticleEntity articleEntity);
}
