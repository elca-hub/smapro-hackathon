package com.mokimaki.arput.presentation.request.community;

import org.hibernate.validator.constraints.Length;

public record CommunityCreateRequest (
        @Length(min = 1, max = 20)
        String name,
        @Length(min = 1, max = 3000)
        String description
) { }
