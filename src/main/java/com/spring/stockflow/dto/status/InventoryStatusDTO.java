package com.spring.stockflow.dto.status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryStatusDTO {
    private Long id;
    private String productCode;
    private String productName;
    private String category;
    private String unit;
    private Integer safetyStock;
    private Integer currentStock;
    private String stockStatus;
    private String remarks;
    private LocalDateTime regDate;
}
