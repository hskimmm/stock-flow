package com.spring.stockflow.security.config;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.dto.UserContext;
import com.spring.stockflow.dto.UserDTO;
import com.spring.stockflow.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
@RequiredArgsConstructor
@Log4j2
public class FormUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다 = " + username);
        }

        //권한
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return new UserContext(userDTO, authorities);
    }
}
