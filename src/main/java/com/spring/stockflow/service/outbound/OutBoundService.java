package com.spring.stockflow.service.outbound;

import com.spring.stockflow.domain.OutBound;
import com.spring.stockflow.dto.outbound.CreateOutBoundDTO;
import com.spring.stockflow.response.ApiResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface OutBoundService {
    List<OutBound> getOutBounds();

    OutBound getOutBound(Long id);

    ApiResponse<?> addOutBound(@Valid CreateOutBoundDTO createOutBoundDTO, Long id);
}
