package com.spring.stockflow.controller.dashboard;

import com.spring.stockflow.dto.history.InventoryHistoryDTO;
import com.spring.stockflow.service.dashboard.DashboardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
@Log4j2
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public String dashboard(Model model) {
        //총 재고 수량
        int totalStock = dashboardService.getTotalStock();
        //오늘 입고 건수
        int todayInboundQty = dashboardService.getTodayInboundQty();
        //오늘 출고 건수
        int todayOutboundQty = dashboardService.getTodayOutboundQty();
        //재고 부족 상품 건수
        int stockShortageCount = dashboardService.getStockShortageCount();
        //최근 입출고 내역
        List<InventoryHistoryDTO> recentStockHistoryList = dashboardService.getRecentStockHistoryList();

        model.addAttribute("totalStock", totalStock);
        model.addAttribute("todayInboundQty", todayInboundQty);
        model.addAttribute("todayOutboundQty", todayOutboundQty);
        model.addAttribute("stockShortageCount", stockShortageCount);
        model.addAttribute("recentStockHistoryList", recentStockHistoryList);
        model.addAttribute("menuActive", "dashboard");
        return "dashboard/dashboard";
    }
}
