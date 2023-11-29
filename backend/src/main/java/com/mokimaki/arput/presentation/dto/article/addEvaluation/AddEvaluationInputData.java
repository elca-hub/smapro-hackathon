package com.mokimaki.arput.presentation.dto.article.addEvaluation;

public record AddEvaluationInputData (
        String userId,
        String articleId,
        int evaluationId
) { }
