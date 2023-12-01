package com.mokimaki.arput.infrastructure.elasticsearch;


import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ElasticSearchContext extends Repository<ArticleIndex, String> {
    List<ArticleIndex> findByTitleOrContent(String title, String content);
    void deleteById(String id);

    void save(ArticleIndex articleIndex);

    List<ArticleIndex> findAll();
}
