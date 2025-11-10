package com.spring.stockflow.controller.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.dto.CreateUserDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.admin.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
@Log4j2
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public String getUsers(Model model) {
        List<User> users = adminService.getUsers();

        model.addAttribute("users", users);
        model.addAttribute("menuActive", "admin");
        return "admin/admin";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("menuActive", "admin-user-add");
        return "admin/admin-user-add";
    }

    @GetMapping("/users/exists")
    public ResponseEntity<ApiResponse<?>> usersExists(@RequestParam String userId) {
        ApiResponse<?> response = adminService.usersExists(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createUser(@Valid @ModelAttribute CreateUserDTO createUserDTO) {
        ApiResponse<?> response = adminService.createUser(createUserDTO);
        return ResponseEntity.ok(response);
    }
}
