package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.community.CommunityId;
import com.mokimaki.arput.domain.model.community.EntryCode;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

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

    public void convert(Community community) {
        this.id = community.getId().getId();
        this.name = community.getName();
        this.description = community.getDescription();
        this.entryCode = community.getEntryCode().getEntryCode();
    }

    public Community convert() {
        return new Community(
                new CommunityId(this.id),
                this.name,
                this.description,
                new EntryCode(this.entryCode)
        );
    }
}
