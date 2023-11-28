package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.ICommunityRepository;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.update.CommunityUpdateInputData;
import com.mokimaki.arput.presentation.dto.community.update.CommunityUpdateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CommunityUpdateUseCase implements IUseCase<CommunityUpdateInputData, CommunityUpdateOutputData> {
    private final ICommunityRepository communityRepository;
    private final IUserRepository userRepository;

    public CommunityUpdateUseCase(ICommunityRepository communityRepository, IUserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommunityUpdateOutputData execute(CommunityUpdateInputData input) throws UseCaseException {
        try {
            Community community = communityRepository.findById(input.communityId).orElseThrow(() -> new UseCaseException("コミュニティが見つかりませんでした"));
            User user = userRepository.findById(input.userId).orElseThrow(() -> new UseCaseException("ユーザーが見つかりませんでした"));

            if (!community.isOwner(user)) {
                throw new UseCaseException("コミュニティのオーナーではありません");
            }

            community.setName(input.communityName);
            community.setDescription(input.communityDescription);

            communityRepository.update(community);

            return new CommunityUpdateOutputData();
        } catch (Exception e) {
            throw new UseCaseException("コミュニティの更新に失敗しました： " + e.getMessage());
        }
    }
}
