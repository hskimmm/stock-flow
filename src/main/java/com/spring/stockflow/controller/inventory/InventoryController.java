package com.spring.stockflow.controller.inventory;

import com.spring.stockflow.dto.status.InventoryStatusDTO;
import com.spring.stockflow.service.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Log4j2
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    public String getInventories(Model model) {
        List<InventoryStatusDTO> inventories = inventoryService.getInventories();
        model.addAttribute("inventories", inventories);
        model.addAttribute("menuActive", "inventory");
        return "inventory/inventory";
    }
}
