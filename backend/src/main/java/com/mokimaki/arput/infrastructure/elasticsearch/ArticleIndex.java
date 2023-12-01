package com.mokimaki.arput.infrastructure.elasticsearch;

import com.mokimaki.arput.domain.model.article.Article;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "articles")
@Getter
public class ArticleIndex {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private final String title;

    @Field(type = FieldType.Text)
    private final String content;

    public ArticleIndex(Article article) {
        this.id = article.getId().getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
