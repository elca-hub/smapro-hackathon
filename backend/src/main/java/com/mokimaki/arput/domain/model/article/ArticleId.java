package com.mokimaki.arput.domain.model.article;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ArticleId {
    private final String id;

    public ArticleId(String id) {
        this.id = id;
    }

    public ArticleId() {
        this.id = UUID.randomUUID().toString();
    }
}
