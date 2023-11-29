package com.mokimaki.arput.infrastructure.security;

import com.mokimaki.arput.domain.repository.IUserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

public class MyRequestHeaderAuthenticationFilter extends RequestHeaderAuthenticationFilter {
    public MyRequestHeaderAuthenticationFilter(AuthenticationManager authenticationManager, IUserRepository userRepository) {
        setPrincipalRequestHeader("Authorization");
        setExceptionIfHeaderMissing(false); // ヘッダにauthorizationがなくても認証処理を続行する
        setAuthenticationManager(authenticationManager);
        setRequiresAuthenticationRequestMatcher(new RegexRequestMatcher(".*", null));

        this.setAuthenticationSuccessHandler((request, response, authentication) -> {
            String email = authentication.getName();

            if (request.getRequestURI().equals("/user/logout")) {
                userRepository.resetToken(email);
                return;
            }

            String userId = userRepository.findByMailAddress(email).orElseThrow().getId().getId();
            request.setAttribute("userId", userId);

            logger.info("auth success");
        });

        this.setAuthenticationFailureHandler((request, response, authentication) -> {
            logger.info("auth failure");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        });
    }
}
