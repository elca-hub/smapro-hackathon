package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.db.IArticleRepository;
import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.infrastructure.elasticsearch.ArticleIndex;
import com.mokimaki.arput.infrastructure.elasticsearch.ElasticSearchRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.update.ArticleUpdateInputData;
import com.mokimaki.arput.presentation.dto.article.update.ArticleUpdateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateArticleUseCase implements IUseCase<ArticleUpdateInputData, ArticleUpdateOutputData> {
    private final IArticleRepository articleRepository;
    private final ICommunityRepository communityRepository;
    private final ElasticSearchRepository elasticSearchRepository;

    public UpdateArticleUseCase(IArticleRepository articleRepository, ICommunityRepository communityRepository, ElasticSearchRepository elasticSearchRepository) {
        this.articleRepository = articleRepository;
        this.communityRepository = communityRepository;
        this.elasticSearchRepository = elasticSearchRepository;
    }

    @Override
    public ArticleUpdateOutputData execute(ArticleUpdateInputData input) throws UseCaseException {
        try {
            Article article = articleRepository.findByArticleIdAndUserId(new ArticleId(input.articleId()), new UserId(input.userId())).orElseThrow(() -> new UseCaseException("記事が見つかりませんでした"));

            Optional<Community> community = input.communityId() == null ? Optional.empty() : Optional.of(
                    communityRepository.findById(input.communityId()).orElseThrow(() -> new UseCaseException("コミュニティが存在しません"))
            );

            article.setTitle(input.articleTitle());
            article.setContent(input.articleContent());
            article.setCommunity(community);

            articleRepository.update(article);

            elasticSearchRepository.save(new ArticleIndex().convert(article));

            return new ArticleUpdateOutputData();
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
