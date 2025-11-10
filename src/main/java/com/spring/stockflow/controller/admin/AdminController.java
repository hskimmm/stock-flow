package com.spring.stockflow.controller.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.dto.CreateUserDTO;
import com.spring.stockflow.dto.EditUserDTO;
import com.spring.stockflow.dto.PageDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.admin.AdminService;
import com.spring.stockflow.util.Pagination;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public String getUsers(@ModelAttribute(value = "pagination") Pagination pagination, Model model) {
        List<User> users = adminService.getUsers(pagination);
        PageDTO pageDTO = new PageDTO(pagination, adminService.getTotalCount(pagination));

        model.addAttribute("users", users);
        model.addAttribute("page", pageDTO);
        model.addAttribute("menuActive", "admin");
        return "admin/admin";
    }

    @GetMapping("/add")
    public String addUserForm(@ModelAttribute(value = "pagination") Pagination pagination, Model model) {
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

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable(value = "id") Long id, @ModelAttribute(value = "pagination") Pagination pagination, Model model) {
        User user = adminService.getUser(id);

        model.addAttribute("user", user);
        model.addAttribute("menuActive", "admin-user-edit");
        return "admin/admin-user-edit";
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> editUser(@Valid @ModelAttribute EditUserDTO editUserDTO) {
        ApiResponse<?> response = adminService.editUser(editUserDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteUser(@PathVariable(value = "id") Long id) {
        ApiResponse<?> response = adminService.deleteUser(id);
        return ResponseEntity.ok(response);
    }
}
