package com.spring.stockflow.controller.inbound;

import com.spring.stockflow.domain.Inbound;
import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.UserDTO;
import com.spring.stockflow.dto.inbound.CreateInboundDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.inbound.InboundService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inbound")
@RequiredArgsConstructor
@Log4j2
public class InboundController {

    private final InboundService inboundService;

    @GetMapping
    public String getInbounds(Model model) {
        List<Inbound> inbounds = inboundService.getInbounds();
        model.addAttribute("inbounds", inbounds);
        model.addAttribute("menuActive", "inbound-list");
        return "inbound/inbound-list";
    }

    @GetMapping("/{id}")
    public String getInbound(@PathVariable(value = "id") Long id, Model model) {
        Inbound inbound = inboundService.getInbound(id);
        model.addAttribute("inbound", inbound);
        model.addAttribute("menuActive", "inbound-detail");
        return "inbound/inbound-detail";
    }

    @GetMapping("/add")
    public String addInboundForm(Model model) {
        List<Product> products = inboundService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("menuActive", "inbound-add");
        return "inbound/inbound-add";
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addInbound(@Valid @ModelAttribute CreateInboundDTO createInboundDTO, @AuthenticationPrincipal UserDTO userDTO) {
        ApiResponse<?> response = inboundService.addInbound(createInboundDTO, userDTO.getId());
        return ResponseEntity.ok(response);
    }
}
