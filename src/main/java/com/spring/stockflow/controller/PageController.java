package com.spring.stockflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/outbound/list")
    public String outboundList(Model model) {
        model.addAttribute("menuActive", "outbound-list");
        return "outbound/outbound-list";
    }

    @GetMapping("/outbound/add")
    public String outboundAdd(Model model) {
        model.addAttribute("menuActive", "outbound-add");
        return "outbound/outbound-add";
    }

    @GetMapping("/outbound/detail")
    public String outboundDetail(Model model) {
        model.addAttribute("menuActive", "outbound-detail");
        return "outbound/outbound-detail";
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {
        model.addAttribute("menuActive", "inventory");
        return "inventory/inventory";
    }

    @GetMapping("/statistics")
    public String statistics(Model model) {
        model.addAttribute("menuActive", "statistics");
        return "statistics/statistics";
    }

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
