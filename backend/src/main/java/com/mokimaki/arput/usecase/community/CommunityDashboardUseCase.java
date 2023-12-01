package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.dashboard.CommunityDashboardInputData;
import com.mokimaki.arput.presentation.dto.community.dashboard.CommunityDashboardOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityDashboardUseCase implements IUseCase<CommunityDashboardInputData, List<CommunityDashboardOutputData>> {
    private final ICommunityRepository communityRepository;

    public CommunityDashboardUseCase(ICommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public List<CommunityDashboardOutputData> execute(CommunityDashboardInputData input) throws UseCaseException {
        try {
            List<Community> communities = communityRepository.findOwnCommunities(new UserId(input.getUserId()));

            return communities.stream().map((community ->
                    new CommunityDashboardOutputData(community.getName(),
                            community.getDescription(),
                            community.getEntryCode().getEntryCode()))
            ).toList();
        } catch (Exception e) {
            throw new UseCaseException("コミュニティの取得に失敗しました。");
        }
    }
}
