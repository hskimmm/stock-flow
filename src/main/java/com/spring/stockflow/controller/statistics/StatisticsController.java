package com.spring.stockflow.controller.statistics;

import com.spring.stockflow.dto.statistics.CategoryStockDTO;
import com.spring.stockflow.dto.statistics.InOutboundStatDTO;
import com.spring.stockflow.dto.statistics.TopInProductDTO;
import com.spring.stockflow.dto.statistics.TopOutProductDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.statistics.StatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/statistics")
@RequiredArgsConstructor
@Log4j2
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public String getStatistics(Model model) {
        //많이 입고된 상품 TOP 5
        List<TopInProductDTO> topInProductDTOList = statisticsService.getTopInProductList();
        //많이 출고된 상품 TOP 5
        List<TopOutProductDTO> topOutProductDTOList = statisticsService.getTopOutProductList();

        model.addAttribute("topInProductDTOList", topInProductDTOList);
        model.addAttribute("topOutProductDTOList", topOutProductDTOList);
        model.addAttribute("menuActive", "statistics");
        return "statistics/statistics";
    }

    @GetMapping("/category-stock")
    public ResponseEntity<ApiResponse<?>> getCategoryStock() {
        ApiResponse<?> response = statisticsService.getCategoryStockList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/daily-in-out")
    public ResponseEntity<ApiResponse<?>> getDailyInOut(@RequestParam String period, @RequestParam(required = false) String month) {
        ApiResponse<?> response = statisticsService.getDailyInOutData(period, month);
        return ResponseEntity.ok(response);
    }
}
