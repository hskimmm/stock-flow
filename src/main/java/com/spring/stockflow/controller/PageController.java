package com.spring.stockflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/notice/edit")
    public String noticeEdit(Model model) {
        model.addAttribute("menuActive", "notice");
        return "notice/notice-edit";
    }
}
