package com.spring.stockflow.service.inventory;

import com.spring.stockflow.dto.status.InventoryStatusDTO;
import com.spring.stockflow.util.Pagination;

import java.util.List;

public interface InventoryService {
    List<InventoryStatusDTO> getInventories(Pagination pagination);

    int getTotalInventories(Pagination pagination);
}
