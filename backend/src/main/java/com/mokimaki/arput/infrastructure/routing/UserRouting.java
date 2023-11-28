package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.user.UserUpdateRequest;
import com.mokimaki.arput.presentation.response.user.UserCreateResponse;
import com.mokimaki.arput.presentation.response.user.UserLogoutResponse;
import com.mokimaki.arput.presentation.response.user.UserShowResponse;
import com.mokimaki.arput.presentation.response.user.UserUpdateResponse;
import com.mokimaki.arput.presentation.user.create.UserCreateInputData;
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
    UserShowResponse getUser(@PathVariable String userId);

    @PutMapping("/{userId}")
    UserUpdateResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest inputData);
}
