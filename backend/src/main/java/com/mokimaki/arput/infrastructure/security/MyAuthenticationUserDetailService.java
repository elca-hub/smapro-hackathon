package com.mokimaki.arput.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mokimaki.arput.infrastructure.security.utils.UserSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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

        UserSecurity user = new UserSecurity(decodedJWT.getClaim("username").asString(),"");

        return new MyUserDetails(user);
    }
}
