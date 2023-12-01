package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.domain.repository.ICommunityRepository;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.elasticsearch.ArticleIndex;
import com.mokimaki.arput.infrastructure.elasticsearch.ElasticSearchRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.create.ArticleCreateInputData;
import com.mokimaki.arput.presentation.dto.article.create.ArticleCreateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateArticleUseCase implements IUseCase<ArticleCreateInputData, ArticleCreateOutputData> {
    private final IArticleRepository articleRepository;
    private final IUserRepository userRepository;
    private final ICommunityRepository communityRepository;
    private final ElasticSearchRepository elasticSearchRepository;

    public CreateArticleUseCase(
            IArticleRepository articleRepository,
            IUserRepository userRepository,
            ICommunityRepository communityRepository,
            ElasticSearchRepository elasticSearchRepository
    ) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
        this.communityRepository = communityRepository;
        this.elasticSearchRepository = elasticSearchRepository;
    }

    @Override
    public ArticleCreateOutputData execute(ArticleCreateInputData input) throws UseCaseException {
        try {
            User user = userRepository.findById(input.userId()).orElseThrow(() -> new UseCaseException("ユーザが存在しません"));

            Optional<Community> community = input.communityId() == null ? Optional.empty() : Optional.of(
                    communityRepository.findById(input.communityId()).orElseThrow(() -> new UseCaseException("コミュニティが存在しません"))
            );

            var article = new Article(
                    new ArticleId(),
                    input.title(),
                    input.content(),
                    user,
                    community
            );

            articleRepository.create(article);

            elasticSearchRepository.save(new ArticleIndex(article));

            return new ArticleCreateOutputData();
        } catch (Exception e) {
            throw new UseCaseException("ユーザの作成に失敗しました：" + e.getMessage());
        }
    }
}
