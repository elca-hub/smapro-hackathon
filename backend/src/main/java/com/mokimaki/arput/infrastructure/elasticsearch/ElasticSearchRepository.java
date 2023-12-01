package com.mokimaki.arput.infrastructure.elasticsearch;


import org.springframework.data.repository.CrudRepository;

public interface ElasticSearchRepository extends CrudRepository<ArticleIndex, String> {
}
