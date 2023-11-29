package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.response.article.AddEvaluationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/article/{articleId}/evaluation")
public interface ArticleEvaluationRouting {
    @PostMapping("/")
    AddEvaluationResponse addEvaluation(String articleId, int evaluationId);
}
