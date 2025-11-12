package com.spring.stockflow.service.inbound;

import com.spring.stockflow.domain.Inbound;

import java.util.List;

public interface InboundService {
    List<Inbound> getInbounds();

    Inbound getInbound(Long id);
}
