package com.mokimaki.arput.presentation.user.create;

public record InputData(
        String name,
        String mailAddress,
        String password,
        String passwordConfirmation,
        String schoolName
) { }
