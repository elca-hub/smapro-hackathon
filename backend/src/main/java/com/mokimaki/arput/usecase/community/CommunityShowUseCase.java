package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.show.CommunityShowInputData;
import com.mokimaki.arput.presentation.dto.community.show.CommunityShowOutputData;
import com.mokimaki.arput.presentation.dto.community.show.CommunityUserItem;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CommunityShowUseCase implements IUseCase<CommunityShowInputData, CommunityShowOutputData> {
    private final ICommunityRepository communityRepository;
    private final IUserRepository userRepository;

    public CommunityShowUseCase(ICommunityRepository communityRepository, IUserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommunityShowOutputData execute(CommunityShowInputData input) throws UseCaseException {
        try {
            Community community = communityRepository.findById(input.communityId())
                    .orElseThrow(() -> new UseCaseException("コミュニティが見つかりませんでした"));

            if (community.getMembers().stream().noneMatch(member -> member.getId().getId().equals(input.userId()))) {
                throw new UseCaseException("ユーザーがコミュニティに参加していません");
            }

            User user = userRepository.findById(input.userId()).orElseThrow(() -> new UseCaseException("ユーザーが見つかりませんでした"));

            return new CommunityShowOutputData(
                    community.getId().getId(),
                    community.getName(),
                    community.getDescription(),
                    community.isOwner(user),
                    community.getEntryCode().getEntryCode(),
                    community.getMembers().stream().map(member -> new CommunityUserItem(
                            member.getId().getId(),
                            member.getName()
                    )).toList()
            );
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
