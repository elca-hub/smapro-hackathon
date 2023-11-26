package com.mokimaki.arput.presentation.user.create;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

public record InputData(
        @Length(min = 1, max = 20)
        String name,

        @Email
        String mailAddress,

        @Length(min = 8, max = 20)
        String password,

        @Length(min = 8, max = 20)
        String passwordConfirmation,

        @Length(min = 1, max = 30)
        String schoolName,

        @Length(min = 0, max = 100)
        String bio
) { }
