package com.mokimaki.arput.presentation.request.article;

import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

public record ArticleCreateRequest(
        @NonNull
        @Length(min = 1, max = 100)
        String title,
        @NonNull
        @Length(min = 1, max = 3000)
        String content,
        String communityId
) { }
