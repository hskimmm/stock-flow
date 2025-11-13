package com.spring.stockflow.service.outbound;

import com.spring.stockflow.domain.OutBound;
import com.spring.stockflow.dto.outbound.CreateOutBoundDTO;
import com.spring.stockflow.mapper.outbound.OutBoundMapper;
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

    @Transactional
    @Override
    public ApiResponse<?> addOutBound(CreateOutBoundDTO createOutBoundDTO, Long id) {
        try {
            String outBoundNo = generateInboundCode();
            OutBound outBound = OutBound.builder()
                    .outBoundNo(outBoundNo)
                    .productId(createOutBoundDTO.getProductId())
                    .outboundDate(createOutBoundDTO.getOutBoundDate())
                    .quantity(createOutBoundDTO.getQuantity())
                    .reason(createOutBoundDTO.getReason())
                    .remarks(createOutBoundDTO.getRemarks())
                    .regUserId(id)
                    .build();
            outBoundMapper.addOutBound(outBound);

            return new ApiResponse<>(true, "상품을 출고하였습니다");
        } catch (DataAccessException e) {
            log.error("출고 등록(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("출고 등록 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("출고 등록(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("출고 등록 중 오류가 발생하였습니다");
        }
    }

    //출고번호 생성
    private String generateInboundCode() {
        String dateStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String prefix = "OUT-" + dateStr + "-";

        String lastCode = outBoundMapper.findLastOutboundCodeByDate(dateStr);

        int sequence = 1;
        if (lastCode != null) {
            String lastSeq = lastCode.substring(lastCode.lastIndexOf("-") + 1);
            sequence = Integer.parseInt(lastSeq) + 1;
        }
        return prefix + String.format("%03d", sequence);
    }
}
