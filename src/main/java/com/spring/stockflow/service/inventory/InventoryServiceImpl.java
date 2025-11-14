package com.spring.stockflow.service.inventory;

import com.spring.stockflow.dto.status.InventoryStatusDTO;
import com.spring.stockflow.mapper.inventory.InventoryMapper;
import com.spring.stockflow.util.Pagination;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class InventoryServiceImpl implements InventoryService{
    private final InventoryMapper inventoryMapper;

    @Transactional(readOnly = true)
    @Override
    public List<InventoryStatusDTO> getInventories(Pagination pagination) {
        try {
            return inventoryMapper.getInventories(pagination);
        } catch (DataAccessException e) {
            log.error("재고현황 목록 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("재고현황 목록 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("재고현황 목록 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("재고현황 목록 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public int getTotalInventories(Pagination pagination) {
        try {
            return inventoryMapper.getTotalInventories(pagination);
        } catch (DataAccessException e) {
            log.error("재고현황 전체 목록 카운트(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("재고현황 목록 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("재고현황 전체 목록 카운트(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("재고현황 목록 조회 중 오류가 발생하였습니다");
        }
    }
}
