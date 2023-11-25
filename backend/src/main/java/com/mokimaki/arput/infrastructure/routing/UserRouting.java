package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.infrastructure.response.user.logout.UserLogoutResponse;
import com.mokimaki.arput.presentation.user.create.InputData;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserRouting {
    @PostMapping("/create")
    String createUser(@RequestBody InputData inputData);

    @GetMapping("/secret")
    String secret();

    @GetMapping("/logout")
    UserLogoutResponse logout();
}
