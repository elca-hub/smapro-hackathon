package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.infrastructure.security.utils.CryptPasswordEncoder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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

    public void convert(User user) {
        this.id = user.getId().getId();
        this.mailAddress = user.getMailAddress();
        this.userName = user.getName();
        this.password = CryptPasswordEncoder.fetch().encode(user.getPassword().getPassword());
        this.schoolName = user.getSchoolName();
        this.token = null;
        this.bio = user.getBio();
    }
}
