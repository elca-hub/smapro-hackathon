package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.ArticleEvaluationRouting;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationInputData;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationOutputData;
import com.mokimaki.arput.presentation.response.article.AddEvaluationResponse;
import com.mokimaki.arput.usecase.article.AddEvaluationUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleEvaluationController implements ArticleEvaluationRouting {
    private final AddEvaluationUseCase addEvaluationUseCase;

    public ArticleEvaluationController(AddEvaluationUseCase addEvaluationUseCase) {
        this.addEvaluationUseCase = addEvaluationUseCase;
    }

    @Override
    public AddEvaluationResponse addEvaluation(@PathVariable String articleId, @RequestParam("evaluationId") int evaluationId) {
        var input = new AddEvaluationInputData(articleId, evaluationId);
        var response = new AddEvaluationResponse();
        try {
            AddEvaluationOutputData output = addEvaluationUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
