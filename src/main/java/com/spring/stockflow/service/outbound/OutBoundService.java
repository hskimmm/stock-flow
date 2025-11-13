package com.spring.stockflow.service.outbound;

import com.spring.stockflow.domain.OutBound;

import java.util.List;

public interface OutBoundService {
    List<OutBound> getOutBounds();

    OutBound getOutBound(Long id);
}
