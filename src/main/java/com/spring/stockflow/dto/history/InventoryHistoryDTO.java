package com.spring.stockflow.dto.history;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryHistoryDTO {
    private String type;
    private Long id;
    private String transactionNo;
    private Long productId;
    private String productName;
    private LocalDateTime transactionDate;
    private Integer quantity;
    private String reason;
    private String supplier;
    private String remarks;
    private String regUserName;
    private LocalDateTime regDate;
}
