package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.EvaluationEntity;
import org.springframework.data.repository.CrudRepository;

public interface EvaluationContext extends CrudRepository<EvaluationEntity, Integer> {
}
