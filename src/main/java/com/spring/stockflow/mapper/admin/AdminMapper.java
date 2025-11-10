package com.spring.stockflow.mapper.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<User> getUsers(Pagination pagination);

    boolean usersExists(String userId);

    void createUser(User user);

    User getUser(Long id);

    void editUser(User user);

    void deleteUser(Long id);

    int getTotalCount();
}
