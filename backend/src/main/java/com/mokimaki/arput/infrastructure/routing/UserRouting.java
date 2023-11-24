package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.controller.IUserController;
import com.mokimaki.arput.presentation.user.create.InputData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRouting implements IUserController {
    @Override
    @PostMapping("/create")
    public void createUser(@RequestBody InputData inputData) {
        System.out.println("UserRouting.createUser");
    }
}
