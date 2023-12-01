package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.delete.CommunityDeleteInputData;
import com.mokimaki.arput.presentation.dto.community.delete.CommunityDeleteOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteCommunityUseCase implements IUseCase<CommunityDeleteInputData, CommunityDeleteOutputData> {
    private final ICommunityRepository communityRepository;
    private final IUserRepository userRepository;

    public DeleteCommunityUseCase(ICommunityRepository communityRepository, IUserRepository userRepository) {
        this.communityRepository = communityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CommunityDeleteOutputData execute(CommunityDeleteInputData input) throws UseCaseException {
        try {
            Community community = communityRepository.findById(input.communityId).orElseThrow(() -> new UseCaseException("コミュニティが見つかりませんでした"));
            User user = userRepository.findById(input.userId).orElseThrow(() -> new UseCaseException("ユーザーが見つかりませんでした"));

            if (!community.isOwner(user)) {
                throw new UseCaseException("コミュニティのオーナーではありません");
            }

            communityRepository.delete(community);

            return new CommunityDeleteOutputData();
        } catch (Exception e) {
            throw new UseCaseException("コミュニティの削除に失敗しました： " + e.getMessage());
        }
    }
}
