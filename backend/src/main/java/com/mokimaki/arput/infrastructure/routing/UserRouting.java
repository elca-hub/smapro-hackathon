package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.request.user.UserUpdateRequest;
import com.mokimaki.arput.presentation.response.user.*;
import com.mokimaki.arput.presentation.dto.user.create.UserCreateInputData;
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
    UserShowResponse getUser(String userId);

    @PutMapping("/{userId}")
    UserUpdateResponse updateUser(String userId, @RequestBody UserUpdateRequest inputData);

    @DeleteMapping("/{userId}")
    UserDeleteResponse deleteUser(String userId);
}
