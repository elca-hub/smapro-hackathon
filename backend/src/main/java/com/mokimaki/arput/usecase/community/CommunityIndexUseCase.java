package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.index.CommunityIndexInputData;
import com.mokimaki.arput.presentation.dto.community.index.CommunityIndexOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityIndexUseCase implements IUseCase<CommunityIndexInputData, List<CommunityIndexOutputData>> {
    private final ICommunityRepository communityRepository;

    public CommunityIndexUseCase(ICommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public List<CommunityIndexOutputData> execute(CommunityIndexInputData input) throws UseCaseException {
        try {
            List<Community> communities = communityRepository.findByUserId(new UserId(input.getUserId()));

            return communities.stream().map(community -> new CommunityIndexOutputData(
                    community.getId().getId(),
                    community.getName(),
                    community.getDescription(),
                    community.getMembers().size()
            )).toList();
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
