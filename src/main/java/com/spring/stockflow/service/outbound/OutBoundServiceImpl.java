package com.spring.stockflow.service.outbound;

import com.spring.stockflow.domain.OutBound;
import com.spring.stockflow.mapper.outbound.OutBoundMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class OutBoundServiceImpl implements OutBoundService{
    private final OutBoundMapper outBoundMapper;

    @Transactional(readOnly = true)
    @Override
    public List<OutBound> getOutBounds() {
        try {
            return outBoundMapper.getOutBounds();
        } catch (DataAccessException e) {
            log.error("출고목록 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("출고목록 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("출고목록 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("출고목록 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public OutBound getOutBound(Long id) {
        try {
            return outBoundMapper.getOutBound(id);
        } catch (DataAccessException e) {
            log.error("출고 상세 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("출고 상세 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("출고 상세 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("출고 상세 조회 중 오류가 발생하였습니다");
        }
    }
}
