package com.spring.stockflow.dto.statistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InOutboundStatDTO {
    private String dateLabel;
    private Integer inboundQuantity;
    private Integer outboundQuantity;
}
