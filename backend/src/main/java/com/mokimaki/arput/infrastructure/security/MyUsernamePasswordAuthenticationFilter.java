package com.mokimaki.arput.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.security.utils.LoginForm;
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
import java.util.Date;
import java.util.UUID;

@Slf4j
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public MyUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager,
            String secret,
            IUserRepository userRepository
    ) {
        this.authenticationManager = authenticationManager;

        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/user/login"));

        this.setAuthenticationSuccessHandler((request, response, authentication) -> {
            var issuedAt = new Date();

            String email = authentication.getName(); // メールアドレスを取得
            String contentToken = UUID.randomUUID().toString();

            userRepository.updateToken(email, contentToken);


            String token = JWT.create()
                    .withIssuer("arput")
                    .withIssuedAt(issuedAt)
                    .withExpiresAt(new Date(issuedAt.getTime() + 1000 * 60 * 60))
                    .withClaim("username", authentication.getName())
                    .withClaim("contentToken", contentToken)
                    .sign(Algorithm.HMAC256(secret));

            var user = userRepository.findByMailAddress(email).orElseThrow(() -> new RuntimeException("ユーザーが見つかりません"));

            response.setHeader("X-AUTH-TOKEN", token);
            response.setHeader("X-UID", user.getId().getId());
            response.setStatus(HttpServletResponse.SC_OK);
        });

        this.setAuthenticationFailureHandler((request, response, authentication) -> {
            log.info("login failure");
            log.warn(authentication.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
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
