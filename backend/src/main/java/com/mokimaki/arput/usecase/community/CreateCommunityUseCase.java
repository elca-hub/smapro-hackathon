package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.community.CommunityId;
import com.mokimaki.arput.domain.model.community.EntryCode;
import com.mokimaki.arput.domain.repository.ICommunityRepository;
import com.mokimaki.arput.infrastructure.exception.DomainException;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateInputData;
import com.mokimaki.arput.presentation.dto.community.create.CommunityCreateOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateCommunityUseCase implements IUseCase<CommunityCreateInputData, CommunityCreateOutputData> {
    private final ICommunityRepository communityRepository;

    public CreateCommunityUseCase(ICommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public CommunityCreateOutputData execute(CommunityCreateInputData inputData) throws UseCaseException {
        try {
            var community = new Community(
                    new CommunityId(),
                    inputData.name,
                    inputData.description,
                    new EntryCode()
            );

            communityRepository.create(community);

            return new CommunityCreateOutputData();
        } catch (DomainException e) {
            throw new UseCaseException(e.getMessage());
        } catch (Exception e) {
            throw new UseCaseException("コミュニティの作成に失敗しました");
        }
    }
}
