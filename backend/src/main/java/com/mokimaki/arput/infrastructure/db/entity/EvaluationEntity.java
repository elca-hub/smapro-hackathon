package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String emoji;

    @OneToMany
    private List<EvaluatedArticleEntity> evaluatedArticleEntities;

    public void convert(Evaluation evaluation) {
        this.id = evaluation.getId();
        this.name = evaluation.getName();
        this.emoji = evaluation.getEmoji();
    }

    public Evaluation convert() {
        return new Evaluation(this.id, this.name, this.emoji);
    }
}
