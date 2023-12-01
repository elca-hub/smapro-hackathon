package com.mokimaki.arput.domain.model.article;

import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;
import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.infrastructure.exception.DomainException;
import lombok.Getter;
import lombok.NonNull;

import java.util.Map;
import java.util.Optional;

@Getter
public class Article {
    private final int MAX_TITLE_LENGTH = 100;

    private final int MAX_CONTENT_LENGTH = 3000;

    private final ArticleId id;
    private String title;
    private String content;
    private final User writer;
    private Map<Evaluation, Long> evaluationLongMap;
    private Optional<Community> community = Optional.empty();

    public Article(
            @NonNull ArticleId id,
            @NonNull String title,
            @NonNull String content,
            @NonNull User writer,
            Optional<Community> community
    ) {
        this.id = id;
        this.setTitle(title);
        this.setContent(content);
        this.writer = writer;
        this.community = community;
    }

    public Article(
            @NonNull ArticleId id,
            @NonNull String title,
            @NonNull String content,
            @NonNull User writer,
            Optional<Community> community,
            Map<Evaluation, Long> evaluationLongMap
    ) {
        this.id = id;
        this.setTitle(title);
        this.setContent(content);
        this.writer = writer;
        this.evaluationLongMap = evaluationLongMap;
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

    public void setCommunity(Optional<Community> community) {
        this.community = community;
    }

    public boolean isWriter(User user) {
        return this.writer.getId().getId().equals(user.getId().getId());
    }

    public void setEvaluationLongMap(Map<Evaluation, Long> evaluationLongMap) {
        this.evaluationLongMap = evaluationLongMap;
    }
}
