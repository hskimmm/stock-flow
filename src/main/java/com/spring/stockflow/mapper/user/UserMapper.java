package com.spring.stockflow.mapper.user;

import com.spring.stockflow.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User loadUserByUsername(String username);
}
