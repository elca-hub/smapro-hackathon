package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.db.IArticleRepository;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.WriterOutputData;
import com.mokimaki.arput.presentation.dto.article.show.ArticleShowInputData;
import com.mokimaki.arput.presentation.dto.article.show.ArticleShowOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ShowArticleUseCase implements IUseCase<ArticleShowInputData, ArticleShowOutputData> {
    private final IArticleRepository articleRepository;
    private final IUserRepository userRepository;

    public ShowArticleUseCase(IArticleRepository articleRepository, IUserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ArticleShowOutputData execute(ArticleShowInputData input) throws UseCaseException {
        try {
            Article article = this.articleRepository.findByArticleIdAndUserId(
                    new ArticleId(input.articleId()),
                    new UserId(input.userId())
            ).orElseThrow(() -> new UseCaseException("記事が存在しません"));

            return new ArticleShowOutputData(
                    article.getId().getId(),
                    article.getTitle(),
                    article.getContent(),
                    new WriterOutputData(
                            article.getWriter().getId().getId(),
                            article.getWriter().getName()
                    ),
                    article.getEvaluationLongMap().entrySet().stream().collect(
                            Collectors.toMap(
                                    entry -> entry.getKey().getName(),
                                    Map.Entry::getValue
                            )
                    ),
                    article.getCommunity().isEmpty() ? null : new com.mokimaki.arput.presentation.dto.article.CommunityOutputData(
                            article.getCommunity().get().getId().getId(),
                            article.getCommunity().get().getName(),
                            article.getCommunity().get().getDescription()
                    )
            );
        } catch (Exception e) {
            throw new UseCaseException("記事の取得に失敗しました：" + e.getMessage());
        }
    }
}
