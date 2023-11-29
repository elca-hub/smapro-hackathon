package com.mokimaki.arput.usecase.article;

import com.mokimaki.arput.domain.model.article.ArticleId;
import com.mokimaki.arput.domain.repository.IArticleRepository;
import com.mokimaki.arput.domain.repository.IEvaluationRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationInputData;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class AddEvaluationUseCase implements IUseCase<AddEvaluationInputData, AddEvaluationOutputData> {
    private final IArticleRepository articleRepository;
    private final IEvaluationRepository evaluationRepository;

    public AddEvaluationUseCase(IArticleRepository articleRepository, IEvaluationRepository evaluationRepository) {
        this.articleRepository = articleRepository;
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public AddEvaluationOutputData execute(AddEvaluationInputData input) throws UseCaseException {
        try {
            var article = articleRepository.findById(new ArticleId(input.articleId())).orElseThrow(() -> new UseCaseException("記事の取得に失敗しました"));
            var evaluation = evaluationRepository.findById(input.evaluationId()).orElseThrow(() -> new UseCaseException("評価の情報の取得に失敗しました"));

            articleRepository.addEvaluation(article, evaluation);

            return new AddEvaluationOutputData();
        } catch (Exception e) {
            throw new UseCaseException("評価の追加に失敗しました：" + e.getMessage());
        }
    }
}
