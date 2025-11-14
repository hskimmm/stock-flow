package com.spring.stockflow.mapper.inventory;

import com.spring.stockflow.dto.status.InventoryStatusDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {
    List<InventoryStatusDTO> getInventories();
}
