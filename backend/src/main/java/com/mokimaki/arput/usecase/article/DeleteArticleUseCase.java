package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.delete.ArticleDeleteInputData;
import com.mokimaki.arput.presentation.dto.article.delete.ArticleDeleteOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteArticleUseCase implements IUseCase<ArticleDeleteInputData, ArticleDeleteOutputData> {
    private final IArticleRepository articleRepository;

    public DeleteArticleUseCase(IArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDeleteOutputData execute(ArticleDeleteInputData input) throws UseCaseException {
        try {
            Article article = articleRepository.findByArticleIdAndUserId(new ArticleId(input.articleId()), new UserId(input.userId())).orElseThrow(() -> new UseCaseException("記事が見つかりませんでした"));

            articleRepository.delete(article);

            return new ArticleDeleteOutputData();
        } catch (Exception e) {
            throw new UseCaseException("記事の削除に失敗しました。：" + e.getMessage());
        }
    }
}
