package com.mokimaki.arput.presentation.dto.article.search;

import java.util.List;

public record ArticleSearchOutputData(
        List<ArticleSearchItem> items
) { }
