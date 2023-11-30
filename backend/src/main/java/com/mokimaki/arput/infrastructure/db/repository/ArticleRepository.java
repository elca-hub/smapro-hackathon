package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.db.context.ArticleContext;
import com.mokimaki.arput.infrastructure.db.context.EvaluatedArticleContext;
import com.mokimaki.arput.infrastructure.db.context.UserContext;
import com.mokimaki.arput.infrastructure.db.entity.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ArticleRepository implements IArticleRepository {
    private final ArticleContext articleContext;
    private final UserContext userContext;
    private final EvaluatedArticleContext evaluatedArticleContext;

    public ArticleRepository(
            ArticleContext articleContext,
            UserContext userContext,
            EvaluatedArticleContext evaluatedArticleContext
    ) {
        this.articleContext = articleContext;
        this.userContext = userContext;
        this.evaluatedArticleContext = evaluatedArticleContext;
    }

    @Override
    public void create(Article article) {
        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        articleContext.save(articleEntity);
    }

    @Override
    public Optional<Article> findById(ArticleId id) {
        return articleContext.findById(id.getId()).map(ArticleEntity::convert);
    }

    @Override
    public Optional<Article> findByArticleIdAndUserId(ArticleId articleId, UserId userId) {
        UserEntity writer = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザが存在しません"));

        return articleContext.findByIdAndWriter(articleId.getId(), writer).map(articleEntity -> {
            Article article = articleEntity.convert();
            article.setEvaluationLongMap(this.countEvaluation(articleEntity));

            CommunityEntity communityEntity = articleEntity.getCommunity();

            article.setCommunity(communityEntity == null ? Optional.empty() : Optional.of(communityEntity.convert()));
            return article;
        });
    }

    @Override
    public List<Article> findByUserId(UserId userId) {
        UserEntity writer = userContext.findById(userId.getId()).orElseThrow(() -> new RuntimeException("ユーザが存在しません"));

        return articleContext.findByWriter(writer).stream().map(articleEntity -> {
            Article article = articleEntity.convert();
            article.setEvaluationLongMap(this.countEvaluation(articleEntity));
            return article;
        }).toList();
    }

    @Override
    public void update(Article article) {
        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        articleContext.save(articleEntity);
    }

    @Override
    public void delete(Article article) {
        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        evaluatedArticleContext.deleteByArticle(articleEntity);

        articleContext.deleteById(article.getId().getId());
    }

    @Override
    public void addEvaluation(User user, Article article, Evaluation evaluation) {
        EvaluatedArticleEntity evaluatedArticleEntity = convertArticleAndEvaluation(user, article, evaluation);

        evaluatedArticleContext.save(evaluatedArticleEntity);
    }

    @Override
    public void removeEvaluation(User user, Article article, Evaluation evaluation) {
        var userEntity = new UserEntity();
        userEntity.convert(user);

        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        var evaluationEntity = new EvaluationEntity();
        evaluationEntity.convert(evaluation);

        evaluatedArticleContext.deleteByUserAndArticleAndEvaluation(userEntity, articleEntity, evaluationEntity);
    }

    @Override
    public boolean isAlreadyEvaluated(User user, Article article, Evaluation evaluation) {
        var userEntity = new UserEntity();
        userEntity.convert(user);

        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        var evaluationEntity = new EvaluationEntity();
        evaluationEntity.convert(evaluation);

        return evaluatedArticleContext.findByUserAndArticleAndEvaluation(userEntity, articleEntity, evaluationEntity).isPresent();
    }

    private EvaluatedArticleEntity convertArticleAndEvaluation(User user, Article article, Evaluation evaluation) {
        var userEntity = new UserEntity();
        userEntity.convert(user);

        var articleEntity = new ArticleEntity();
        articleEntity.convert(article);

        var evaluationEntity = new EvaluationEntity();
        evaluationEntity.convert(evaluation);

        var evaluatedArticleEntity = new EvaluatedArticleEntity();
        evaluatedArticleEntity.setEvaluation(evaluationEntity);
        evaluatedArticleEntity.setArticle(articleEntity);
        evaluatedArticleEntity.setUser(userEntity);

        return evaluatedArticleEntity;
    }

    private Map<Evaluation, Long> countEvaluation(ArticleEntity articleEntity) {
        // 二次元目は[評価ID, 評価数]の配列
        Object[][] objects = evaluatedArticleContext.countEvaluation(articleEntity);

        Map<Evaluation, Long> mapper = new HashMap<>();

        for (Object[] object : objects) {
            EvaluationEntity evaluationEntity = (EvaluationEntity) object[0];
            mapper.put(evaluationEntity.convert(), (Long) object[1]);
        }

        return mapper;
    }
}
