package com.spring.stockflow.service.dashboard;

import com.spring.stockflow.dto.history.InventoryHistoryDTO;
import com.spring.stockflow.mapper.dashboard.DashboardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class DashboardServiceImpl implements DashboardService{

    private final DashboardMapper dashboardMapper;

    @Transactional(readOnly = true)
    @Override
    public int getTotalStock() {
        return dashboardMapper.getTotalStock();
    }

    @Transactional(readOnly = true)
    @Override
    public int getTodayInboundQty() {
        return dashboardMapper.getTodayInboundQty();
    }

    @Transactional(readOnly = true)
    @Override
    public int getTodayOutboundQty() {
        return dashboardMapper.getTodayOutboundQty();
    }

    @Transactional(readOnly = true)
    @Override
    public int getStockShortageCount() {
        return dashboardMapper.getStockShortageCount();
    }

    @Transactional(readOnly = true)
    @Override
    public List<InventoryHistoryDTO> getRecentStockHistoryList() {
        return dashboardMapper.getRecentStockHistoryList();
    }
}
