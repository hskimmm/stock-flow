package com.spring.stockflow.service.statistics;

import com.spring.stockflow.dto.statistics.CategoryStockDTO;
import com.spring.stockflow.dto.statistics.InOutboundStatDTO;
import com.spring.stockflow.dto.statistics.TopInProductDTO;
import com.spring.stockflow.dto.statistics.TopOutProductDTO;
import com.spring.stockflow.mapper.statistics.StatisticsMapper;
import com.spring.stockflow.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsMapper statisticsMapper;

    @Transactional(readOnly = true)
    @Override
    public List<TopInProductDTO> getTopInProductList() {
        return statisticsMapper.getTopInProductList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TopOutProductDTO> getTopOutProductList() {
        return statisticsMapper.getTopOutProductList();
    }

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<?> getCategoryStockList() {
        try {
            List<CategoryStockDTO> categoryStockDTOList = statisticsMapper.getCategoryStockList();
            return new ApiResponse<>(true, "재고 현황 데이터 정상 로드", categoryStockDTOList);
        } catch (DataAccessException e) {
            log.error("재고 현황 데이터(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("재고 현황 차트 데이터를 로드 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("재고 현황 데이터(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("재고 현황 차트 데이터를 로드 중 오류가 발생하였습니다");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<?> getDailyInOutData(String period, String month) {
        try {
            switch (period) {
                case "today":
                    return getTodayInOutData();
                case "week":
                    return getWeekInOutData();
                case "month":
                    return getMonthInOutData();
                case "custom":
                    if (month == null || month.isEmpty()) {
                        throw new IllegalArgumentException("날짜 데이터가 없습니다");
                    }
                    return getCustomInOutData(month);
                default:
                    throw new IllegalArgumentException("날짜 데이터가 없습니다");
            }
        } catch (IllegalArgumentException e) {
            log.error("기간별 입출고 데이터 조회(인자 없음) = {}", e.getMessage());
            throw new RuntimeException("기간별 입출고 데이터 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("기간별 입출고 데이터 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("기간별 입출고 데이터 조회 중 오류가 발생하였습니다");
        }
    }

    private ApiResponse<?> getTodayInOutData() {
        List<InOutboundStatDTO> inOutboundStatDTOList = statisticsMapper.getTodayInOutData();
        return new ApiResponse<>(true, "오늘 입출고 현황 데이터 로드 성공", inOutboundStatDTOList);
    }

    private ApiResponse<?> getWeekInOutData() {
        List<InOutboundStatDTO> inOutboundStatDTOList = statisticsMapper.getWeekInOutData();
        return new ApiResponse<>(true, "이번주 입출고 현황 데이터 로드 성공", inOutboundStatDTOList);
    }

    private ApiResponse<?> getMonthInOutData() {
        List<InOutboundStatDTO> inOutboundStatDTOList = statisticsMapper.getMonthInOutData();
        return new ApiResponse<>(true, "이번달 입출고 현황 데이터 로드 성공", inOutboundStatDTOList);
    }

    private ApiResponse<?> getCustomInOutData(String month) {
        List<InOutboundStatDTO> inOutboundStatDTOList = statisticsMapper.getCustomInOutData(month);
        return new ApiResponse<>(true, "기간 선택 입출고 현황 데이터 로드 성공", inOutboundStatDTOList);
    }
}
