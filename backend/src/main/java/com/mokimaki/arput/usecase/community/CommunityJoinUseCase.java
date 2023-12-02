package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.join.CommunityJoinInputData;
import com.mokimaki.arput.presentation.dto.community.join.CommunityJoinOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CommunityJoinUseCase implements IUseCase<CommunityJoinInputData, CommunityJoinOutputData> {
    private ICommunityRepository communityRepository;
    private IUserRepository userRepository;

    public CommunityJoinUseCase(ICommunityRepository communityRepository, IUserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommunityJoinOutputData execute(CommunityJoinInputData input) throws UseCaseException {
        try {
            var user = userRepository.findById(input.userId()).orElseThrow(() -> new UseCaseException("ユーザーが見つかりませんでした。"));
            var community = communityRepository.findById(input.communityId()).orElseThrow(() -> new UseCaseException("コミュニティが見つかりませんでした。"));

            if (!community.getEntryCode().getEntryCode().equals(input.entryCode())) {
                throw new UseCaseException("エントリーコードが一致しませんでした。");
            }

            if (community.getMembers().stream().anyMatch(m -> m.getId().getId().equals(user.getId().getId()))) {
                throw new UseCaseException("既に参加しています。");
            }

            communityRepository.join(user, community);

            return new CommunityJoinOutputData();
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
