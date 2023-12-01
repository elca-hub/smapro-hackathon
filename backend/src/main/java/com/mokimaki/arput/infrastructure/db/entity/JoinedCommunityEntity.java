package com.mokimaki.arput.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "joined_community")
public class JoinedCommunityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "community_id", referencedColumnName = "id")
    private CommunityEntity communityEntity;
}
