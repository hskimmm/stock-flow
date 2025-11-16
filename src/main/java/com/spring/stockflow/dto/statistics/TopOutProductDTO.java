package com.spring.stockflow.dto.statistics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopOutProductDTO {
    private String productName;
    private String unit;
    private Integer totalQuantity;
}
