package com.mokimaki.arput.presentation.dto.article.index;

import com.mokimaki.arput.presentation.dto.article.CommunityOutputData;

import java.util.Map;

public record ArticleIndexOutputData (
        String articleId,
        String title,
        String content,
        Map<String, Long> evaluations,
        CommunityOutputData community

) { }
