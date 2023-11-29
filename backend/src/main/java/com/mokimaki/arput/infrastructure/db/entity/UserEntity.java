package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.model.user.UserId;
import com.mokimaki.arput.domain.model.user.password.EncryptPassword;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
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
    public List<CommunityEntity> communityEntity;

    @OneToMany
    public List<JoinedCommunityEntity> joinedCommunityEntity;

    @OneToMany
    public List<ArticleEntity> articleEntity;

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
