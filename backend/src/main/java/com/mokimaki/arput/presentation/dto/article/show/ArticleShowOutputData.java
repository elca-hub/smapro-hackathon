package com.mokimaki.arput.presentation.dto.article.show;

import com.mokimaki.arput.presentation.dto.article.CommunityOutputData;
import com.mokimaki.arput.presentation.dto.article.WriterOutputData;

import java.util.Map;

public record ArticleShowOutputData (
        String articleId,
        String title,
        String content,
        WriterOutputData owner,
        Map<String, Long> evaluations,
        CommunityOutputData community
) { }
