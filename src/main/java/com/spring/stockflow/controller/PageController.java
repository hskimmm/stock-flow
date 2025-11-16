package com.spring.stockflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/notice/list")
    public String noticeList(Model model) {
        model.addAttribute("menuActive", "notice");
        return "notice/notice-list";
    }

    @GetMapping("/notice/add")
    public String noticeAdd(Model model) {
        model.addAttribute("menuActive", "notice");
        return "notice/notice-add";
    }

    @GetMapping("/notice/detail")
    public String noticeDetail(Model model) {
        model.addAttribute("menuActive", "notice");
        return "notice/notice-detail";
    }

    @GetMapping("/notice/edit")
    public String noticeEdit(Model model) {
        model.addAttribute("menuActive", "notice");
        return "notice/notice-edit";
    }
}
