package com.mokimaki.arput.domain.model.article;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.infrastructure.exception.DomainException;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class Article {
    private final int MAX_TITLE_LENGTH = 100;

    private final int MAX_CONTENT_LENGTH = 3000;

    private final ArticleId id;
    private String title;
    private String content;
    private final User writer;

    public Article(
            @NonNull ArticleId id,
            @NonNull String title,
            @NonNull String content,
            @NonNull User writer
    ) {
        this.id = id;
        this.setTitle(title);
        this.setContent(content);
        this.writer = writer;
    }

    public void setTitle(String title) {
        if (title.length() > MAX_TITLE_LENGTH) {
            throw new DomainException("記事のタイトルは" + MAX_TITLE_LENGTH + "文字以内で入力してください。");
        } else if (title.isEmpty()) {
            throw new DomainException("記事のタイトルは必須です。");
        }
        this.title = title;
    }

    public void setContent(String content) {
        if (content.length() > MAX_CONTENT_LENGTH) {
            throw new DomainException("記事の本文は" + MAX_CONTENT_LENGTH + "文字以内で入力してください。");
        } else if (content.isEmpty()) {
            throw new DomainException("記事の本文は必須です。");
        }
        this.content = content;
    }
}
