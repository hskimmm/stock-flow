package com.spring.stockflow.service.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.dto.CreateUserDTO;
import com.spring.stockflow.dto.EditUserDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.Pagination;
import jakarta.validation.Valid;

import java.util.List;

public interface AdminService {
    List<User> getUsers(Pagination pagination);

    ApiResponse<?> usersExists(String userId);

    ApiResponse<?> createUser(@Valid CreateUserDTO createUserDTO);

    User getUser(Long id);

    ApiResponse<?> editUser(@Valid EditUserDTO editUserDTO);

    ApiResponse<?> deleteUser(Long id);

    int getTotalCount();
}
