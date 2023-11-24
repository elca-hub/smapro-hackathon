package com.mokimaki.arput.infrastructure.routing;

import com.mokimaki.arput.presentation.user.create.InputData;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserRouting {
    @PostMapping("/create")
    void createUser();
}
