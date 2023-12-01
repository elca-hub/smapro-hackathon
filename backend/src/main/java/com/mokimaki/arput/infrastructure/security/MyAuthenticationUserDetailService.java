package com.mokimaki.arput.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.db.IUserRepository;
import com.mokimaki.arput.infrastructure.security.utils.UserSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyAuthenticationUserDetailService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Value("${arput.secret}")
    private String secret;

    private final IUserRepository userRepository;

    public MyAuthenticationUserDetailService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        DecodedJWT decodedJWT;

        try {
            decodedJWT = JWT.require(Algorithm.HMAC256(secret)).build().verify(token.getPrincipal().toString());
        } catch (JWTDecodeException e) {
            throw new BadCredentialsException("Authorization header token is invalid");
        }

        if (decodedJWT.getToken().isEmpty()) {
            throw new UsernameNotFoundException("Authorization header must not be empty");
        }

        var contentToken = decodedJWT.getClaim("contentToken").asString();
        var username = decodedJWT.getClaim("username").asString();

        User userByToken = userRepository.findByToken(contentToken).orElseThrow(() -> new UsernameNotFoundException("user not found"));

        if (!userByToken.getMailAddress().equals(username)) {
            throw new IllegalAccessError("Authorization header token is invalid");
        }

        UserSecurity user = new UserSecurity(username,"passwordAdo");

        return new MyUserDetails(user);
    }
}
