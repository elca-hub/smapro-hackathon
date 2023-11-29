package com.mokimaki.arput.presentation.dto.article;

public record ArticleCreateInputData (
    String userId,
    String title,
    String content
) { }
