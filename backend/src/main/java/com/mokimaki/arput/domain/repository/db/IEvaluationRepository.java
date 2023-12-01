package com.mokimaki.arput.domain.repository.db;

import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;

import java.util.Optional;

public interface IEvaluationRepository {
    Optional<Evaluation> findById(int id);
}
