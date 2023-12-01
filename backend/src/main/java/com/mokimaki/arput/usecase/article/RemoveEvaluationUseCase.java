package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.db.IArticleRepository;
import com.mokimaki.arput.domain.repository.db.IEvaluationRepository;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.removeEvaluation.RemoveEvaluationInputData;
import com.mokimaki.arput.presentation.dto.article.removeEvaluation.RemoveEvaluationOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class RemoveEvaluationUseCase implements IUseCase<RemoveEvaluationInputData, RemoveEvaluationOutputData> {
    private final IArticleRepository articleRepository;
    private final IEvaluationRepository evaluationRepository;
    private final IUserRepository userRepository;

    public RemoveEvaluationUseCase(IArticleRepository articleRepository, IEvaluationRepository evaluationRepository, IUserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.evaluationRepository = evaluationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public RemoveEvaluationOutputData execute(RemoveEvaluationInputData input) throws UseCaseException {
        try {
            Article article = articleRepository.findById(new ArticleId(input.articleId())).orElseThrow(() -> new UseCaseException("記事が見つかりませんでした"));
            Evaluation evaluation = evaluationRepository.findById(input.evaluationId()).orElseThrow(() -> new UseCaseException("評価が見つかりませんでした"));
            User user = userRepository.findById(input.userId()).orElseThrow(() -> new UseCaseException("ユーザが見つかりませんでした"));

            if (article.getWriter().getId().getId().equals(user.getId().getId())) {
                throw new UseCaseException("自分の記事には評価できません");
            }

            articleRepository.removeEvaluation(user, article, evaluation);

            return new RemoveEvaluationOutputData();
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
