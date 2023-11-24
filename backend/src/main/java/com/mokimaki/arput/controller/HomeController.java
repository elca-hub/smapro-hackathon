package com.mokimaki.arput.controller;

import com.mokimaki.arput.infrastructure.routing.HomeRouting;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController implements HomeRouting {
    @Override
    public String home() {
        return "Hello, world!";
    }
}
