package com.mokimaki.arput.presentation.dto.article.create;

public record ArticleCreateInputData (
    String userId,
    String title,
    String content
) { }
