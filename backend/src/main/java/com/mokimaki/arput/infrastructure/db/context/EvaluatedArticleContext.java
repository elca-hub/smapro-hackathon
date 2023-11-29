package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.ArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.EvaluatedArticleEntity;
import com.mokimaki.arput.infrastructure.db.entity.EvaluationEntity;
import com.mokimaki.arput.infrastructure.db.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EvaluatedArticleContext extends JpaRepository<EvaluatedArticleEntity, Integer> {
    @Query("SELECT e.evaluation, COUNT(e) FROM EvaluatedArticleEntity e WHERE e.article = ?1 GROUP BY e.evaluation")
    Object[][] countEvaluation(ArticleEntity articleEntity);

    @Transactional
    void deleteByArticle(ArticleEntity articleEntity);

    @Transactional
    void deleteByUserAndArticleAndEvaluation(UserEntity userEntity, ArticleEntity articleEntity, EvaluationEntity evaluationEntity);

    Optional<EvaluatedArticleEntity> findByUserAndArticleAndEvaluation(UserEntity userEntity, ArticleEntity articleEntity, EvaluationEntity evaluationEntity);
}
