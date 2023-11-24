package com.mokimaki.arput.infrastructure.db.entity;

import com.mokimaki.arput.domain.model.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public void convert(User user) {
        this.id = user.getId().getId();
        this.mailAddress = user.getMailAddress();
        this.userName = user.getName();
        this.password = new BCryptPasswordEncoder().encode(user.getPassword());
        this.schoolName = user.getSchoolName();
    }
}
