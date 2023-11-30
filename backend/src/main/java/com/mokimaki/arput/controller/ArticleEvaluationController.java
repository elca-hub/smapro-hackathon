package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.infrastructure.routing.ArticleEvaluationRouting;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationInputData;
import com.mokimaki.arput.presentation.dto.article.addEvaluation.AddEvaluationOutputData;
import com.mokimaki.arput.presentation.dto.article.removeEvaluation.RemoveEvaluationInputData;
import com.mokimaki.arput.presentation.dto.article.removeEvaluation.RemoveEvaluationOutputData;
import com.mokimaki.arput.presentation.response.article.AddEvaluationResponse;
import com.mokimaki.arput.presentation.response.article.RemoveEvaluationResponse;
import com.mokimaki.arput.usecase.article.AddEvaluationUseCase;
import com.mokimaki.arput.usecase.article.RemoveEvaluationUseCase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleEvaluationController implements ArticleEvaluationRouting {
    private final AddEvaluationUseCase addEvaluationUseCase;
    private final RemoveEvaluationUseCase removeEvaluationUseCase;

    public ArticleEvaluationController(AddEvaluationUseCase addEvaluationUseCase, RemoveEvaluationUseCase removeEvaluationUseCase) {
        this.addEvaluationUseCase = addEvaluationUseCase;
        this.removeEvaluationUseCase = removeEvaluationUseCase;
    }

    @Override
    public AddEvaluationResponse addEvaluation(@RequestAttribute String userId, @PathVariable String articleId, @RequestParam("evaluationId") int evaluationId) {
        var input = new AddEvaluationInputData(userId, articleId, evaluationId);
        var response = new AddEvaluationResponse();
        try {
            AddEvaluationOutputData output = addEvaluationUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }

    @Override
    public RemoveEvaluationResponse deleteEvaluation(@RequestAttribute String userId, @PathVariable String articleId, @RequestParam("evaluationId") int evaluationId) {
        var input = new RemoveEvaluationInputData(userId, articleId, evaluationId);
        var response = new RemoveEvaluationResponse();

        try {
            RemoveEvaluationOutputData output = removeEvaluationUseCase.execute(input);

            return response.success(output);
        } catch (UseCaseException e) {
            return response.error(e);
        }
    }
}
