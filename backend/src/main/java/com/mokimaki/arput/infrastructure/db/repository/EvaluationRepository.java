package com.mokimaki.arput.infrastructure.db.repository;

import com.mokimaki.arput.domain.model.article.evaluation.Evaluation;
import com.mokimaki.arput.domain.repository.IEvaluationRepository;
import com.mokimaki.arput.infrastructure.db.context.EvaluationContext;
import com.mokimaki.arput.infrastructure.db.entity.EvaluationEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EvaluationRepository implements IEvaluationRepository {
    private final EvaluationContext evaluationContext;

    public EvaluationRepository(EvaluationContext evaluationContext) {
        this.evaluationContext = evaluationContext;
    }

    @Override
    public Optional<Evaluation> findById(int id) {
        return evaluationContext.findById(id).map(EvaluationEntity::convert);
    }
}
