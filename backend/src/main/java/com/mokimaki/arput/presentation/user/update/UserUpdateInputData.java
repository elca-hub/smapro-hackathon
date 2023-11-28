package com.mokimaki.arput.presentation.user.update;

import com.mokimaki.arput.presentation.request.user.UserUpdateRequest;
import lombok.Getter;

@Getter
public class UserUpdateInputData{
        private String userId;
        private String name;
        private String mailAddress;
        private String schoolName;
        private String bio;
        private String password;

        public UserUpdateInputData(String userId, UserUpdateRequest userUpdateRequest) {
                this.userId = userId;
                this.name = userUpdateRequest.name();
                this.mailAddress = userUpdateRequest.mailAddress();
                this.schoolName = userUpdateRequest.schoolName();
                this.bio = userUpdateRequest.bio();
                this.password = userUpdateRequest.password();
        }
}
