package com.spring.stockflow.mapper.outbound;

import com.spring.stockflow.domain.OutBound;
import com.spring.stockflow.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutBoundMapper {
    List<OutBound> getOutBounds(Pagination pagination);

    OutBound getOutBound(Long id);

    void addOutBound(OutBound outBound);

    String findLastOutboundCodeByDate(String dateStr);

    int getTotalOutBound(Pagination pagination);
}
