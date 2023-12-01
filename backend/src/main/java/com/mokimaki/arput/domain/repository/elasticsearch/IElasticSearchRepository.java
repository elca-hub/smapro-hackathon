package com.mokimaki.arput.domain.repository.elasticsearch;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElasticSearchRepository<T> {
    void save();
    void delete();
    List<T> search(String query);
}
