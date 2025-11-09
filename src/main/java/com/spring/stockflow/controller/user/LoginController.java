package com.spring.stockflow.controller.user;

import com.spring.stockflow.dto.UserContext;
import com.spring.stockflow.dto.UserDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
public class LoginController {
    @GetMapping("/")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception,
                        Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            // 세션 무효화, SecurityContextHolder 비움, remember-me 쿠키 제거
        }
        return "redirect:/";
    }

    @GetMapping("/denied")
    public String denied(@RequestParam(value = "exception", required = false) String exception,
                         @AuthenticationPrincipal UserDTO userDTO,
                         Model model) {
        model.addAttribute("exception", exception);
        model.addAttribute("userName", userDTO.getUserName());
        model.addAttribute("menuActive", "admin");

        return "login/denied";
    }
}
