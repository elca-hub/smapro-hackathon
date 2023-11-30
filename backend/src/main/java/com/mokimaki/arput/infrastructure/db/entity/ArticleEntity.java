package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.model.article.ArticleId;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

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
    @ManyToOne
    @Nullable
    private CommunityEntity community;

    public void convert(Article article) {
        this.id = article.getId().getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.writer = new UserEntity();
        this.writer.convert(article.getWriter());
        this.community = article.getCommunity().isEmpty() ? null : new CommunityEntity().convert(article.getCommunity().get());
    }

    public Article convert() {
        return new Article(
                new ArticleId(this.id),
                this.title,
                this.content,
                this.writer.convert(),
                this.community == null ? Optional.empty() : Optional.of(this.community.convert())
        );
    }
}
