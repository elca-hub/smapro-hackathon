package com.mokimaki.arput.infrastructure.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

public class MyRequestHeaderAuthenticationFilter extends RequestHeaderAuthenticationFilter {
    public MyRequestHeaderAuthenticationFilter(AuthenticationManager authenticationManager) {
        setPrincipalRequestHeader("Authorization");
        setExceptionIfHeaderMissing(false); // ヘッダにauthorizationがなくても認証処理を続行する
        setAuthenticationManager(authenticationManager);
        setRequiresAuthenticationRequestMatcher(
                new RegexRequestMatcher("/user/.*", null)
        );

        this.setAuthenticationSuccessHandler((request, response, authentication) -> {
            logger.info("auth success");
        });

        this.setAuthenticationFailureHandler((request, response, authentication) -> {
            logger.info("auth failure");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        });
    }
}
