package com.spring.stockflow.controller.outbound;

import com.spring.stockflow.domain.OutBound;
import com.spring.stockflow.service.outbound.OutBoundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/outbound")
@RequiredArgsConstructor
@Log4j2
public class OutBoundController {
    private final OutBoundService outBoundService;

    @GetMapping
    public String getOutBounds(Model model) {
        List<OutBound> outBounds = outBoundService.getOutBounds();
        model.addAttribute("outBounds", outBounds);
        model.addAttribute("menuActive", "outbound-list");
        return "outbound/outbound-list";
    }

    @GetMapping("/{id}")
    public String getOutBound(@PathVariable(value = "id") Long id, Model model) {
        OutBound outBound = outBoundService.getOutBound(id);
        model.addAttribute("outBound", outBound);
        model.addAttribute("menuActive", "outbound-detail");
        return "outbound/outbound-detail";
    }
}
