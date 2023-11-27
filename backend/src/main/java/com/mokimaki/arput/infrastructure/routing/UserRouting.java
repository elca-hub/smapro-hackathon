package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.response.user.create.UserCreateResponse;
import com.mokimaki.arput.presentation.response.user.logout.UserLogoutResponse;
import com.mokimaki.arput.presentation.response.user.update.UserUpdateResponse;
import com.mokimaki.arput.presentation.user.create.UserCreateInputData;
import com.mokimaki.arput.presentation.user.update.UserUpdateInputData;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserRouting {
    @PostMapping("/create")
    UserCreateResponse createUser(@RequestBody UserCreateInputData inputData);

    @PostMapping("/secret")
    String secret();

    @GetMapping("/logout")
    UserLogoutResponse logout();

    @GetMapping("/{userId}")
    String getUser(@PathVariable String userId);

    @PutMapping("/update")
    UserUpdateResponse updateUser(@RequestBody UserUpdateInputData inputData);
}
