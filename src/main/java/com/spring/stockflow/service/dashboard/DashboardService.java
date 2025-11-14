package com.spring.stockflow.service.dashboard;

import com.spring.stockflow.dto.history.InventoryHistoryDTO;

import java.util.List;

public interface DashboardService {
    int getTotalStock();

    int getTodayInboundQty();

    int getTodayOutboundQty();

    int getStockShortageCount();

    List<InventoryHistoryDTO> getRecentStockHistoryList();
}
