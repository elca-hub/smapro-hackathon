package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.community.CommunityId;
import com.mokimaki.arput.domain.model.community.EntryCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class CommunityEntity {
    @Id
    public String id;
    public String name;
    public String description;
    public String entryCode;
    @ManyToOne
    public UserEntity owner;

    @OneToMany
    public List<JoinedCommunityEntity> joinedCommunityEntity;

    public CommunityEntity convert(Community community) {
        this.id = community.getId().getId();
        this.name = community.getName();
        this.description = community.getDescription();
        this.entryCode = community.getEntryCode().getEntryCode();
        this.owner = new UserEntity();
        this.owner.convert(community.getOwner());
        return this;
    }

    public Community convert() {
        return new Community(
                new CommunityId(this.id),
                this.name,
                this.description,
                new EntryCode(this.entryCode),
                this.owner.convert()
        );
    }
}
