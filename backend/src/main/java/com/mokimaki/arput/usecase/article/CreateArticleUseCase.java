package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.ArticleCreateInputData;
import com.mokimaki.arput.presentation.dto.article.ArticleCreateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateArticleUseCase implements IUseCase<ArticleCreateInputData, ArticleCreateOutputData> {
    private final IArticleRepository articleRepository;

    private final IUserRepository userRepository;

    public CreateArticleUseCase(
            IArticleRepository articleRepository,
            IUserRepository userRepository
    ) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ArticleCreateOutputData execute(ArticleCreateInputData input) throws UseCaseException {
        try {
            User user = userRepository.findById(input.userId()).orElseThrow(() -> new UseCaseException("ユーザが存在しません"));
            var article = new Article(
                    new ArticleId(),
                    input.title(),
                    input.content(),
                    user
            );

            articleRepository.create(article);

            return new ArticleCreateOutputData();
        } catch (Exception e) {
            throw new UseCaseException("ユーザの作成に失敗しました：" + e.getMessage());
        }
    }
}
