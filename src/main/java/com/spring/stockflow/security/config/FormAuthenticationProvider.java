package com.spring.stockflow.security.config;

import com.spring.stockflow.dto.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("authenticationProvider")
@RequiredArgsConstructor
@Log4j2
public class FormAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginId = authentication.getName();
        String loginPassword = (String) authentication.getCredentials();

        UserContext userContext = (UserContext) userDetailsService.loadUserByUsername(loginId);
        if (userContext == null) {
            throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다 = " + loginId);
        }

        if (!passwordEncoder.matches(loginPassword, userContext.getPassword())) {
            throw new BadCredentialsException("비밀번호가 다릅니다");
        }

        return new UsernamePasswordAuthenticationToken(userContext.getUserDTO(), null, userContext.getAuthorities()); //userContext.getUserDTO() -> principal
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}
