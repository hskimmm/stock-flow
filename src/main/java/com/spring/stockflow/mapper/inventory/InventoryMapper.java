package com.spring.stockflow.mapper.inventory;

import com.spring.stockflow.dto.status.InventoryStatusDTO;
import com.spring.stockflow.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {
    List<InventoryStatusDTO> getInventories(Pagination pagination);

    int getTotalInventories(Pagination pagination);
}
