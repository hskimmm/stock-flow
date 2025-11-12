package com.spring.stockflow.controller.inbound;

import com.spring.stockflow.domain.Inbound;
import com.spring.stockflow.service.inbound.InboundService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
