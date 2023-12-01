package com.mokimaki.arput.infrastructure.elasticsearch;

import com.mokimaki.arput.domain.model.article.Article;
import com.mokimaki.arput.domain.repository.elasticsearch.IElasticSearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElasticSearchRepository implements IElasticSearchRepository<ArticleIndex> {
    private final ElasticSearchContext elasticSearchContext;

    public ElasticSearchRepository(ElasticSearchContext elasticSearchContext) {
        this.elasticSearchContext = elasticSearchContext;
    }

    @Override
    public void save(Article article) {
        elasticSearchContext.save(new ArticleIndex().convert(article));
    }

    @Override
    public void delete(Article article) {
        elasticSearchContext.deleteById(article.getId().getId());
    }

    @Override
    public List<ArticleIndex> search(String query) {
        return elasticSearchContext.findByTitleOrContent(query, query);
    }
}
