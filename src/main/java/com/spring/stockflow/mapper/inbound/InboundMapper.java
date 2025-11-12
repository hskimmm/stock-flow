package com.spring.stockflow.mapper.inbound;

import com.spring.stockflow.domain.Inbound;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InboundMapper {
    List<Inbound> getInbounds();
}
