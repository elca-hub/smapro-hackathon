package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.repository.db.IArticleRepository;
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
    public SearchArticleUseCase(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleSearchOutputData execute(ArticleSearchInputData input) throws UseCaseException {
        try {
            List<Article> articleIndexList = articleRepository.search(input.getSearchWord());

            var articleIndexFilteredList = articleIndexList.stream().filter(articleIndex ->
                    input.getCommunityId() == null || (articleIndex.getCommunity().isPresent() && articleIndex.getCommunity().get().getId().getId().equals(input.getCommunityId()))
            ).toList();

            return new ArticleSearchOutputData(articleIndexFilteredList.stream().map(article ->
                    new ArticleSearchItem(article.getId().getId(), article.getTitle())
            ).toList());
        } catch (Exception e) {
            throw new UseCaseException("検索中にエラーが発生しました。：" + e.getMessage());
        }
    }
}
