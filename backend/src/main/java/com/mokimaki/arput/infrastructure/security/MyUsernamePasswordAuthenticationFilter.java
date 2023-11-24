package com.mokimaki.arput.infrastructure.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Slf4j
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public MyUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login", "POST"));

        this.setAuthenticationSuccessHandler((request, response, authentication) -> {
            log.info("login success");
            response.setStatus(HttpServletResponse.SC_OK);
        });
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginForm principal = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(principal.getMailAddress(), principal.getPassword())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
