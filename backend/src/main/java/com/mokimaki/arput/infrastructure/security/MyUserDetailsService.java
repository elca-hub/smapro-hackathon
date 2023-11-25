package com.mokimaki.arput.infrastructure.security;

import com.mokimaki.arput.domain.model.user.User;
import com.mokimaki.arput.domain.repository.IUserRepository;
import com.mokimaki.arput.infrastructure.security.utils.UserSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    public MyUserDetailsService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername: {}", username);
        User user = userRepository.findByMailAddress(username).orElseThrow(
                () -> new UsernameNotFoundException("user not found")
        );
        return new MyUserDetails(new UserSecurity(user));
    }
}
