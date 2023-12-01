package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.model.user.password.EncryptPassword;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "user")
public class UserEntity {
    @Id
    public String id;
    public String mailAddress;
    public String userName;
    public String password;
    public String schoolName;
    public String token;
    public String bio;

    @OneToMany
    @JoinColumn(name = "user_id")
    public List<CommunityEntity> communityEntity;

    @OneToMany
    @JoinColumn(name = "user_id")
    public List<JoinedCommunityEntity> joinedCommunityEntity;

    @OneToMany
    @JoinColumn(name = "user_id")
    public List<ArticleEntity> articleEntity;

    @OneToMany
    @JoinColumn(name = "user_id")
    public List<EvaluatedArticleEntity> evaluatedArticleEntity;

    public void convert(User user) {
        this.id = user.getId().getId();
        this.mailAddress = user.getMailAddress();
        this.userName = user.getName();
        this.password = user.getPassword().getPassword();
        this.schoolName = user.getSchoolName();
        this.token = null;
        this.bio = user.getBio();
    }

    public User convert() {
        return new User(
                new UserId(this.id),
                this.mailAddress,
                this.userName,
                new EncryptPassword(this.password),
                this.schoolName,
                this.bio
        );
    }
}
