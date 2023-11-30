package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.CommunityOutputData;
import com.mokimaki.arput.presentation.dto.article.index.ArticleIndexInputData;
import com.mokimaki.arput.presentation.dto.article.index.ArticleIndexOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndexArticleUseCase implements IUseCase<ArticleIndexInputData, List<ArticleIndexOutputData>> {
    private final IArticleRepository articleRepository;

    public IndexArticleUseCase(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<ArticleIndexOutputData> execute(ArticleIndexInputData input) throws UseCaseException {
        try {
            return articleRepository.findByUserId(new UserId(input.userId())).stream().map(article -> new ArticleIndexOutputData(
                    article.getId().getId(),
                    article.getTitle(),
                    article.getContent(),
                    article.getEvaluationLongMap().entrySet().stream().collect(
                            Collectors.toMap(
                                    entry -> entry.getKey().getName(),
                                    Map.Entry::getValue
                            )
                    ),
                    article.getCommunity().isEmpty() ? null : new CommunityOutputData(
                            article.getCommunity().get().getId().getId(),
                            article.getCommunity().get().getName(),
                            article.getCommunity().get().getDescription()
                    )
            )).toList();
        } catch (Exception e) {
            throw new UseCaseException("記事の取得に失敗しました：" + e.getMessage());
        }
    }
}
