package com.mokimaki.arput.infrastructure.db.context;

import com.mokimaki.arput.infrastructure.db.entity.CommunityEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommunityContext extends CrudRepository<CommunityEntity, String> {
}
