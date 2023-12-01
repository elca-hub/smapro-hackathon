package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.db.IArticleRepository;
import com.mokimaki.arput.domain.repository.elasticsearch.IElasticSearchRepository;
import com.mokimaki.arput.infrastructure.elasticsearch.ArticleIndex;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.delete.ArticleDeleteInputData;
import com.mokimaki.arput.presentation.dto.article.delete.ArticleDeleteOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteArticleUseCase implements IUseCase<ArticleDeleteInputData, ArticleDeleteOutputData> {
    private final IArticleRepository articleRepository;
    private final IElasticSearchRepository<ArticleIndex>  elasticSearchRepository;

    public DeleteArticleUseCase(
            IArticleRepository articleRepository,
            IElasticSearchRepository<ArticleIndex> elasticSearchRepository
    ) {
        this.articleRepository = articleRepository;
        this.elasticSearchRepository = elasticSearchRepository;
    }

    @Override
    public ArticleDeleteOutputData execute(ArticleDeleteInputData input) throws UseCaseException {
        try {
            Article article = articleRepository.findByArticleIdAndUserId(new ArticleId(input.articleId()), new UserId(input.userId())).orElseThrow(() -> new UseCaseException("記事が見つかりませんでした"));

            articleRepository.delete(article);

            elasticSearchRepository.delete(article);

            return new ArticleDeleteOutputData();
        } catch (Exception e) {
            throw new UseCaseException("記事の削除に失敗しました。：" + e.getMessage());
        }
    }
}
