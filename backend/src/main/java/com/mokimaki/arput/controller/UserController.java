package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.routing.UserRouting;
import com.mokimaki.arput.presentation.user.create.InputData;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserRouting {
    @Override
    public void createUser() {
        System.out.println("Hello, world!");
    }
}
