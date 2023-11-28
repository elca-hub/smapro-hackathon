package com.mokimaki.arput.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class JoinedCommunityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    public UserEntity user;

    @ManyToOne
    public CommunityEntity community;
}
