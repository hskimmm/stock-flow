package com.spring.stockflow.service.statistics;

import com.spring.stockflow.dto.statistics.CategoryStockDTO;
import com.spring.stockflow.dto.statistics.TopInProductDTO;
import com.spring.stockflow.dto.statistics.TopOutProductDTO;
import com.spring.stockflow.response.ApiResponse;

import java.util.List;

public interface StatisticsService {
    List<TopInProductDTO> getTopInProductList();

    List<TopOutProductDTO> getTopOutProductList();

    ApiResponse<?> getCategoryStockList();

    ApiResponse<?> getDailyInOutData(String period, String month);
}
