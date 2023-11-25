package com.mokimaki.arput.infrastructure.routing;

import org.springframework.web.bind.annotation.GetMapping;

public interface HomeRouting {
    @GetMapping("/")
    String home();
}
