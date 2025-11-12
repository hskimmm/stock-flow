package com.spring.stockflow.dto.inbound;

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
public class CreateInboundDTO {
    @NotNull(message = "입고일자를 선택하세요")
    private LocalDate inboundDate;

    @NotNull(message = "입고 상품을 선택하세요")
    private Long productId;

    @NotNull(message = "입고 수량을 입력하세요")
    private Integer quantity;

    private String supplier;
    private String remarks;
}
