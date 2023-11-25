package com.mokimaki.arput.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mokimaki.arput.infrastructure.security.utils.LoginForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Date;

@Slf4j
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public MyUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager, String secret) {
        this.authenticationManager = authenticationManager;

        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login", "POST"));

        var issuedAt = new Date();

        log.info(secret);

        this.setAuthenticationSuccessHandler((request, response, authentication) -> {
            String token = JWT.create()
                    .withIssuer("arput")
                    .withIssuedAt(issuedAt)
                    .withExpiresAt(new Date(issuedAt.getTime() + 1000 * 60 * 60))
                    .withClaim("username", authentication.getName())
                    .sign(Algorithm.HMAC256(secret));

            response.setHeader("X-AUTH-TOKEN", token);
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
