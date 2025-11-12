package com.spring.stockflow.service.inbound;

import com.spring.stockflow.domain.Inbound;
import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.inbound.CreateInboundDTO;
import com.spring.stockflow.mapper.inbound.InboundMapper;
import com.spring.stockflow.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    @Transactional(readOnly = true)
    @Override
    public List<Product> getProducts() {
        try {
            return inboundMapper.getProducts();
        } catch (DataAccessException e) {
            log.error("상품 목록 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 목록 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("상품 목록 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 목록 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> addInbound(CreateInboundDTO createInboundDTO, Long id) {
        try {
            String inboundNo = generateInboundCode();
            Inbound inbound = Inbound.builder()
                    .inboundNo(inboundNo)
                    .productId(createInboundDTO.getProductId())
                    .inboundDate(createInboundDTO.getInboundDate())
                    .quantity(createInboundDTO.getQuantity())
                    .supplier(createInboundDTO.getSupplier())
                    .remarks(createInboundDTO.getRemarks())
                    .regUserId(id)
                    .build();
            inboundMapper.addInbound(inbound);

            return new ApiResponse<>(true, "상품을 입고 처리하였습니다");
        } catch (DataAccessException e) {
            log.error("상품 등록(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 등록 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("상품 등록(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("상품 등록 중 오류가 발생하였습니다");
        }
    }

    //입고 번호 생성
    private String generateInboundCode() {
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String prefix = "IN-" + dateStr + "-";

        String lastCode = inboundMapper.findLastInboundCodeByDate(dateStr);

        int sequence = 1;
        if (lastCode != null) {
            String lastSeq = lastCode.substring(lastCode.lastIndexOf("-") + 1);
            sequence = Integer.parseInt(lastSeq) + 1;
        }
        return prefix + String.format("%03d", sequence);
    }
}
