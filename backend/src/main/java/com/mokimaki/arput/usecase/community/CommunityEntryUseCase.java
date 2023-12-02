package com.mokimaki.arput.usecase.community;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.community.EntryCode;
import com.mokimaki.arput.domain.repository.db.ICommunityRepository;
import com.mokimaki.arput.infrastructure.exception.UseCaseException;
import com.mokimaki.arput.presentation.dto.community.entry.CommunityEntryInputData;
import com.mokimaki.arput.presentation.dto.community.entry.CommunityEntryOutputData;
import com.mokimaki.arput.usecase.IUseCase;
import org.springframework.stereotype.Service;

@Service
public class CommunityEntryUseCase implements IUseCase<CommunityEntryInputData, CommunityEntryOutputData> {
    private ICommunityRepository communityRepository;

    public CommunityEntryUseCase(ICommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public CommunityEntryOutputData execute(CommunityEntryInputData input) throws UseCaseException {
        try {
            Community community = communityRepository.findByEntryCode(new EntryCode(input.entryCode())).orElseThrow(() -> new UseCaseException("コミュニティが見つかりませんでした。"));
            return new CommunityEntryOutputData(community);
        } catch (Exception e) {
            throw new UseCaseException(e.getMessage());
        }
    }
}
