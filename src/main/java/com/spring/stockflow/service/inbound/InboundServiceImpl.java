package com.spring.stockflow.service.inbound;

import com.spring.stockflow.domain.Inbound;
import com.spring.stockflow.mapper.inbound.InboundMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class InboundServiceImpl implements InboundService{

    private final InboundMapper inboundMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Inbound> getInbounds() {
        try {
            return inboundMapper.getInbounds();
        } catch (DataAccessException e) {
            log.error("입고 내역 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("입고 내역 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("입고 내역 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("입고 내역 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Inbound getInbound(Long id) {
        try {
            return inboundMapper.getInbound(id);
        } catch (DataAccessException e) {
            log.error("입고 상세 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("입고 상세 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("입고 상세 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("입고 상세 조회 중 오류가 발생하였습니다");
        }
    }
}
