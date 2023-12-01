package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.elasticsearch.ArticleIndex;
import com.mokimaki.arput.infrastructure.elasticsearch.ElasticSearchRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.search.ArticleSearchInputData;
import com.mokimaki.arput.presentation.dto.article.search.ArticleSearchItem;
import com.mokimaki.arput.presentation.dto.article.search.ArticleSearchOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SearchArticleUseCase implements IUseCase<ArticleSearchInputData, ArticleSearchOutputData> {
    private final IArticleRepository articleRepository;
    private final ElasticSearchRepository elasticSearchRepository;

    public SearchArticleUseCase(IArticleRepository articleRepository, ElasticSearchRepository elasticSearchRepository) {
        this.articleRepository = articleRepository;
        this.elasticSearchRepository = elasticSearchRepository;
    }

    @Override
    public ArticleSearchOutputData execute(ArticleSearchInputData input) throws UseCaseException {
        try {
            List<ArticleIndex> articleIndexList = elasticSearchRepository.findByTitleOrContent(input.getSearchWord(), input.getSearchWord());

            var articleIndexFilteredList = articleIndexList.stream().filter(articleIndex ->
                    input.getCommunityId() == null || (articleIndex.getCommunityId() != null && articleIndex.getCommunityId().equals(input.getCommunityId()))
            ).toList();

            List<Article> articleList = articleIndexFilteredList.stream().map(articleIndex -> {
                try {
                    return articleRepository.findById(new ArticleId(articleIndex.getId())).orElseThrow(() -> new UseCaseException("記事が見つかりませんでした"));
                } catch (UseCaseException e) {
                    throw new RuntimeException(e);
                }
            }).toList();

            return new ArticleSearchOutputData(articleList.stream().map(article ->
                    new ArticleSearchItem(article.getId().getId(), article.getTitle())
            ).toList());
        } catch (Exception e) {
            throw new UseCaseException("検索中にエラーが発生しました。：" + e.getMessage());
        }
    }
}
