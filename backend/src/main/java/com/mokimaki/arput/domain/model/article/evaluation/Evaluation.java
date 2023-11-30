package com.mokimaki.arput.domain.model.article.evaluation;

import lombok.Getter;

@Getter
public class Evaluation {
    private final int id;
    private final String emoji;
    private final String name;

    public Evaluation(int id, String name, String emoji) {
        this.id = id;
        this.emoji = emoji;
        this.name = name;
    }
}
