package com.spring.stockflow.mapper.admin;

import com.spring.stockflow.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<User> getUsers();

    boolean usersExists(String userId);

    void createUser(User user);

    User getUser(Long id);

    void editUser(User user);
}
