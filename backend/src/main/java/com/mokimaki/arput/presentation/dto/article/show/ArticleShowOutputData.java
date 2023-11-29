package com.mokimaki.arput.presentation.dto.article.show;

import com.mokimaki.arput.presentation.dto.article.WriterOutputData;

public record ArticleShowOutputData (
        String articleId,
        String title,
        String content,
        WriterOutputData owner
) { }
