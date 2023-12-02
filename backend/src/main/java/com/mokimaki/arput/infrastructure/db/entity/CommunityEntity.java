package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.community.Community;
import com.mokimaki.arput.domain.model.community.CommunityId;
import com.mokimaki.arput.domain.model.community.EntryCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "community")
public class CommunityEntity {
    @Id
    public String id;
    public String name;
    public String description;
    public String entryCode;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UserEntity owner;

    @OneToMany(mappedBy = "communityEntity")
    public List<JoinedCommunityEntity> joinedCommunityEntity;

    public CommunityEntity convert(Community community) {
        this.id = community.getId().getId();
        this.name = community.getName();
        this.description = community.getDescription();
        this.entryCode = community.getEntryCode().getEntryCode();
        this.owner = new UserEntity();
        this.owner.convert(community.getOwner());
        this.joinedCommunityEntity = community.getMembers().stream().map(user -> {
            var joinedCommunityEntity = new JoinedCommunityEntity();
            joinedCommunityEntity.setUserEntity(new UserEntity().convert(user));
            joinedCommunityEntity.setCommunityEntity(this);

            return joinedCommunityEntity;
        }).toList();
        return this;
    }

    public Community convert() {
        return new Community(
                new CommunityId(this.id),
                this.name,
                this.description,
                new EntryCode(this.entryCode),
                this.owner.convert(),
                joinedCommunityEntity.stream().map(joinedEntity -> joinedEntity.getUserEntity().convert()).toList()
        );
    }
}
