package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.domain.repository.IEvaluationRepository;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationInputData;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class AddEvaluationUseCase implements IUseCase<AddEvaluationInputData, AddEvaluationOutputData> {
    private final IArticleRepository articleRepository;
    private final IEvaluationRepository evaluationRepository;
    private final IUserRepository userRepository;

    public AddEvaluationUseCase(IArticleRepository articleRepository, IEvaluationRepository evaluationRepository, IUserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.evaluationRepository = evaluationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AddEvaluationOutputData execute(AddEvaluationInputData input) throws UseCaseException {
        try {
            var article = articleRepository.findById(new ArticleId(input.articleId())).orElseThrow(() -> new UseCaseException("記事の取得に失敗しました"));
            var evaluation = evaluationRepository.findById(input.evaluationId()).orElseThrow(() -> new UseCaseException("評価の情報の取得に失敗しました"));
            var user = userRepository.findById(input.userId()).orElseThrow(() -> new UseCaseException("ユーザの取得に失敗しました"));

            if (articleRepository.isAlreadyEvaluated(user, article, evaluation)) {
                throw new UseCaseException("既に評価済みです");
            }

            if (article.getWriter().getId().getId().equals(user.getId().getId())) {
                throw new UseCaseException("自分の記事には評価できません");
            }

            articleRepository.addEvaluation(user, article, evaluation);

            return new AddEvaluationOutputData();
        } catch (Exception e) {
            throw new UseCaseException("評価の追加に失敗しました：" + e.getMessage());
        }
    }
}
