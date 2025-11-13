package com.spring.stockflow.service.outbound;

import com.spring.stockflow.domain.OutBound;
import com.spring.stockflow.dto.outbound.CreateOutBoundDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.Pagination;
import jakarta.validation.Valid;

import java.util.List;

public interface OutBoundService {
    List<OutBound> getOutBounds(Pagination pagination);

    OutBound getOutBound(Long id);

    ApiResponse<?> addOutBound(@Valid CreateOutBoundDTO createOutBoundDTO, Long id);

    int getTotalOutBound(Pagination pagination);
}
