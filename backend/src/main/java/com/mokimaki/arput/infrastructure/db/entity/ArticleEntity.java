package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class ArticleEntity {
    @Id
    private String id;
    private String title;
    @Lob
    @Column(length = 3000)
    private String content;

    @ManyToOne
    private UserEntity writer;

    @OneToMany
    private List<EvaluatedArticleEntity> evaluatedArticleEntities;

    public void convert(Article article) {
        this.id = article.getId().getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.writer = new UserEntity();
        this.writer.convert(article.getWriter());
    }

    public Article convert() {
        return new Article(
                new ArticleId(this.id),
                this.title,
                this.content,
                this.writer.convert()
        );
    }
}
