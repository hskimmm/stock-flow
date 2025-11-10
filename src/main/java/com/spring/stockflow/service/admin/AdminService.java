package com.spring.stockflow.service.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.dto.CreateUserDTO;
import com.spring.stockflow.response.ApiResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface AdminService {
    List<User> getUsers();

    ApiResponse<?> usersExists(String userId);

    ApiResponse<?> createUser(@Valid CreateUserDTO createUserDTO);
}
