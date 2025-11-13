package com.spring.stockflow.controller.outbound;

import com.spring.stockflow.domain.OutBound;
import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.PageDTO;
import com.spring.stockflow.dto.UserDTO;
import com.spring.stockflow.dto.outbound.CreateOutBoundDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.inbound.InboundService;
import com.spring.stockflow.service.outbound.OutBoundService;
import com.spring.stockflow.util.Pagination;
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
@RequestMapping("/outbound")
@RequiredArgsConstructor
@Log4j2
public class OutBoundController {
    private final OutBoundService outBoundService;
    private final InboundService inboundService;

    @GetMapping
    public String getOutBounds(@ModelAttribute(value = "pagination") Pagination pagination, Model model) {
        List<OutBound> outBounds = outBoundService.getOutBounds(pagination);
        PageDTO pageDTO = new PageDTO(pagination, outBoundService.getTotalOutBound(pagination));

        model.addAttribute("page", pageDTO);
        model.addAttribute("outBounds", outBounds);
        model.addAttribute("menuActive", "outbound-list");
        return "outbound/outbound-list";
    }

    @GetMapping("/{id}")
    public String getOutBound(@PathVariable(value = "id") Long id, @ModelAttribute(value = "pagination") Pagination pagination, Model model) {
        OutBound outBound = outBoundService.getOutBound(id);
        model.addAttribute("outBound", outBound);
        model.addAttribute("menuActive", "outbound-detail");
        return "outbound/outbound-detail";
    }

    @GetMapping("/add")
    public String addOutBoundForm(Model model) {
        List<Product> products = inboundService.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("menuActive", "outbound-add");
        return "outbound/outbound-add";
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addOutBound(@Valid @ModelAttribute CreateOutBoundDTO createOutBoundDTO, @AuthenticationPrincipal UserDTO userDTO) {
        ApiResponse<?> response = outBoundService.addOutBound(createOutBoundDTO, userDTO.getId());
        return ResponseEntity.ok(response);
    }
}
