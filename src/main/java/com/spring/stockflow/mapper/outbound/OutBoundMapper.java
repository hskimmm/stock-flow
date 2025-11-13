package com.spring.stockflow.mapper.outbound;

import com.spring.stockflow.domain.OutBound;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OutBoundMapper {
    List<OutBound> getOutBounds();
}
