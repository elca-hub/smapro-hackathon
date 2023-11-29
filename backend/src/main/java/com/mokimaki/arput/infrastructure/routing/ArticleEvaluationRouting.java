package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.response.article.RemoveEvaluationResponse;
import com.mokimaki.arput.presentation.response.article.AddEvaluationResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/article/{articleId}/evaluation")
public interface ArticleEvaluationRouting {
    @PostMapping("/")
    AddEvaluationResponse addEvaluation(String userId, String articleId, int evaluationId);

    @DeleteMapping("/")
    RemoveEvaluationResponse deleteEvaluation(String userId, String articleId, int evaluationId);
}
