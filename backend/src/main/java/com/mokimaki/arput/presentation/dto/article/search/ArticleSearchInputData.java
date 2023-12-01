package com.mokimaki.arput.presentation.dto.article.search;

import lombok.Getter;

@Getter
public class ArticleSearchInputData{
    private final String communityId;
    private EnumSortType sortType = EnumSortType.ASC;
    private EnumSortKey sortKey = EnumSortKey.TITLE;
    private String searchWord = "";

    public ArticleSearchInputData(String communityId, String searchWord){
        this.communityId = communityId;
        this.searchWord = searchWord;
    }

    public ArticleSearchInputData(String communityId, String sortType, String sortKey){
        this.communityId = communityId;
        this.sortType = EnumSortType.valueOf(sortType);
        this.sortKey = EnumSortKey.valueOf(sortKey);
    }

    protected enum EnumSortType{
        ASC,
        DESC
    }

    protected enum EnumSortKey{
        TITLE,
        CREATED_AT,
        UPDATED_AT
    }
}
