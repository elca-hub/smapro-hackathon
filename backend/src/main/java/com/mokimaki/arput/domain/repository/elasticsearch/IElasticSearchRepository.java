package com.mokimaki.arput.domain.repository.elasticsearch;

import com.mokimaki.arput.domain.model.article.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElasticSearchRepository<T> {
    void save(Article article);
    void delete(Article article);
    List<T> search(String query);
}
