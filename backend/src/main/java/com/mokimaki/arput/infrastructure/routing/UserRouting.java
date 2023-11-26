package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.response.user.create.UserCreateResponse;
import com.mokimaki.arput.presentation.response.user.logout.UserLogoutResponse;
import com.mokimaki.arput.presentation.user.create.InputData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserRouting {
    @PostMapping("/create")
    UserCreateResponse createUser(@RequestBody InputData inputData);

    @GetMapping("/secret")
    String secret();

    @GetMapping("/logout")
    UserLogoutResponse logout();
}
