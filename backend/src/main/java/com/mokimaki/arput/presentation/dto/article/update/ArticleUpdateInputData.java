package com.mokimaki.arput.presentation.dto.article.update;

public record ArticleUpdateInputData (
        String userId,
        String articleId,
        String articleTitle,
        String articleContent,
        String communityId
) { }
