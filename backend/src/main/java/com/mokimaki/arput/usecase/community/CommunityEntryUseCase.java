package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.community.EntryCode;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.entry.CommunityEntryInputData;
import com.mokimaki.arput.presentation.dto.community.entry.CommunityEntryOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CommunityEntryUseCase implements IUseCase<CommunityEntryInputData, CommunityEntryOutputData> {
    private ICommunityRepository communityRepository;
    private IUserRepository userRepository;

    public CommunityEntryUseCase(ICommunityRepository communityRepository, IUserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommunityEntryOutputData execute(CommunityEntryInputData input) throws UseCaseException {
        try {
            Community community = communityRepository.findByEntryCode(new EntryCode(input.entryCode())).orElseThrow(() -> new UseCaseException("コミュニティが見つかりませんでした。"));

            User user = userRepository.findById(input.userId()).orElseThrow(() -> new UseCaseException("ユーザーが見つかりませんでした。"));

            if (community.getMembers().stream().anyMatch(m -> m.getId().getId().equals(user.getId().getId()))) {
                throw new UseCaseException("既に参加しています。");
            }

            return new CommunityEntryOutputData(community);
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
