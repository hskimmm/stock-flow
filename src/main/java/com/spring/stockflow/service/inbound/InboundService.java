package com.spring.stockflow.service.inbound;

import com.spring.stockflow.domain.Inbound;
import com.spring.stockflow.domain.Product;
import com.spring.stockflow.dto.inbound.CreateInboundDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.Pagination;
import jakarta.validation.Valid;

import java.util.List;

public interface InboundService {
    List<Inbound> getInbounds(Pagination pagination);

    Inbound getInbound(Long id);

    List<Product> getProducts();

    ApiResponse<?> addInbound(@Valid CreateInboundDTO createInboundDTO, Long id);

    int getTotalInbound(Pagination pagination);
}
