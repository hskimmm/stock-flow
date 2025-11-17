package com.spring.stockflow.dto.outbound;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOutBoundDTO {
    @NotNull(message = "출고일자를 선택하세요")
    private LocalDate outBoundDate;
    
    @NotNull(message = "출고할 상품을 선택하세요")
    private Long productId;
    
    @NotNull(message = "출고할 상품의 수량을 입력하세요")
    private Integer quantity;
    
    @NotEmpty(message = "출고사유를 입력하세요")
    private String reason;

    private String remarks;
}
