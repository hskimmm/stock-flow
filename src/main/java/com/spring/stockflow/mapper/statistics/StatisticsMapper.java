package com.spring.stockflow.mapper.statistics;

import com.spring.stockflow.dto.statistics.CategoryStockDTO;
import com.spring.stockflow.dto.statistics.InOutboundStatDTO;
import com.spring.stockflow.dto.statistics.TopInProductDTO;
import com.spring.stockflow.dto.statistics.TopOutProductDTO;
import com.spring.stockflow.response.ApiResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    List<TopInProductDTO> getTopInProductList();

    List<TopOutProductDTO> getTopOutProductList();

    List<CategoryStockDTO> getCategoryStockList();

    List<InOutboundStatDTO> getTodayInOutData();

    List<InOutboundStatDTO> getWeekInOutData();

    List<InOutboundStatDTO> getMonthInOutData();

    List<InOutboundStatDTO> getCustomInOutData(String month);
}
