package com.mokimaki.arput.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EvaluatedArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private EvaluationEntity evaluation;

    @ManyToOne
    private ArticleEntity article;
    @ManyToOne
    private UserEntity user;
}
