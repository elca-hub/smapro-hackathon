package com.mokimaki.arput.infrastructure.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ArputProperties {
    @Value("${arput.secret}")
    private String jwtSecret;
}
