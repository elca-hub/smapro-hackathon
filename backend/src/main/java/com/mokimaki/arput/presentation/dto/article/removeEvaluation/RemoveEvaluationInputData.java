package com.mokimaki.arput.presentation.dto.article.removeEvaluation;

public record RemoveEvaluationInputData(
        String userId,
        String articleId,
        int evaluationId
) { }
