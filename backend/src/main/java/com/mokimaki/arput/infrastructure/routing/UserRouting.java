package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.response.user.create.UserCreateResponse;
import com.mokimaki.arput.presentation.response.user.logout.UserLogoutResponse;
import com.mokimaki.arput.presentation.user.create.InputData;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserRouting {
    @PostMapping("/create")
    UserCreateResponse createUser(@RequestBody InputData inputData);

    @PostMapping("/secret")
    String secret();

    @GetMapping("/logout")
    UserLogoutResponse logout();
}
