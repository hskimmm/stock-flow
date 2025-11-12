package com.spring.stockflow.mapper.inbound;

import com.spring.stockflow.domain.Inbound;
import com.spring.stockflow.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InboundMapper {
    List<Inbound> getInbounds();

    Inbound getInbound(Long id);

    List<Product> getProducts();

    String findLastInboundCodeByDate(String dateStr);

    void addInbound(Inbound inbound);
}
