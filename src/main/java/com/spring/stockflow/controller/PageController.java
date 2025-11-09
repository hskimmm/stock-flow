package com.spring.stockflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(Model model) {
        model.addAttribute("menuActive", "dashboard");
        return "dashboard/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("menuActive", "dashboard");
        return "dashboard/dashboard";
    }

    @GetMapping("/product/list")
    public String productList(Model model) {
        model.addAttribute("menuActive", "product-list");
        return "product/product-list";
    }

    @GetMapping("/product/add")
    public String productAdd(Model model) {
        model.addAttribute("menuActive", "product-add");
        return "product/product-add";
    }

    @GetMapping("/product/edit")
    public String productEdit(Model model) {
        model.addAttribute("menuActive", "product-list");
        return "product/product-edit";
    }

    @GetMapping("/product/detail")
    public String productDetail(Model model) {
        model.addAttribute("menuActive", "product-list");
        return "product/product-detail";
    }

    @GetMapping("/inbound/list")
    public String inboundList(Model model) {
        model.addAttribute("menuActive", "inbound-list");
        return "inbound/inbound-list";
    }

    @GetMapping("/inbound/add")
    public String inboundAdd(Model model) {
        model.addAttribute("menuActive", "inbound-add");
        return "inbound/inbound-add";
    }

    @GetMapping("/inbound/detail")
    public String inboundDetail(Model model) {
        model.addAttribute("menuActive", "inbound-detail");
        return "inbound/inbound-detail";
    }

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

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("menuActive", "admin");
        return "admin/admin";
    }

    @GetMapping("/admin/add")
    public String adminAdd(Model model) {
        model.addAttribute("menuActive", "admin-user-add");
        return "admin/admin-user-add";
    }

    @GetMapping("/admin/edit")
    public String adminEdit(Model model) {
        model.addAttribute("menuActive", "admin-user-edit");
        return "admin/admin-user-edit";
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
