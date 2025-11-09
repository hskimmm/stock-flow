package com.spring.stockflow.controller.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable(value = "id") Long id, Model model) {

        /*User user = adminService.getUser(id);

        model.addAttribute("user", user);*/
        model.addAttribute("menuActive", "admin-user-edit");
        return "admin/admin-user-edit";
    }
}
