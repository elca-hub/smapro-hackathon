package com.mokimaki.arput.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "evaluated_article")
public class EvaluatedArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "evaluation_id")
    private EvaluationEntity evaluation;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private ArticleEntity article;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
