package com.spring.stockflow.mapper.dashboard;

import com.spring.stockflow.dto.history.InventoryHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DashboardMapper {
    int getTotalStock();

    int getTodayInboundQty();

    int getTodayOutboundQty();

    int getStockShortageCount();

    List<InventoryHistoryDTO> getRecentStockHistoryList();
}
