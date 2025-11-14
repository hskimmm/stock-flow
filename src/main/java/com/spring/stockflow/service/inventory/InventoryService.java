package com.spring.stockflow.service.inventory;

import com.spring.stockflow.dto.status.InventoryStatusDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryStatusDTO> getInventories();
}
