package com.mokimaki.arput.infrastructure.elasticsearch;

import com.mokimaki.arput.domain.model.article.Article;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "articles")
@Getter
@Setter
public class ArticleIndex {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Text)
    private String communityId;

    public ArticleIndex convert(Article article) {
        this.id = article.getId().getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.communityId = article.getCommunity().map(community -> community.getId().getId()).orElse(null);

        return this;
    }
}
