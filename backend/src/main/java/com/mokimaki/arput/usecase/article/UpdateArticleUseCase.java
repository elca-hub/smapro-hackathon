package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.update.ArticleUpdateInputData;
import com.mokimaki.arput.presentation.dto.article.update.ArticleUpdateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateArticleUseCase implements IUseCase<ArticleUpdateInputData, ArticleUpdateOutputData> {
    private final IArticleRepository articleRepository;

    public UpdateArticleUseCase(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleUpdateOutputData execute(ArticleUpdateInputData input) throws UseCaseException {
        try {
            Article article = articleRepository.findByArticleIdAndUserId(new ArticleId(input.articleId()), new UserId(input.userId())).orElseThrow(() -> new UseCaseException("記事が見つかりませんでした"));

            article.setTitle(input.articleTitle());
            article.setContent(input.articleContent());

            articleRepository.update(article);

            return new ArticleUpdateOutputData();
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
