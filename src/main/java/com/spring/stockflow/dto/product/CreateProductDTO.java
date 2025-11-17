package com.spring.stockflow.dto.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDTO {
    @NotEmpty(message = "상품명을 입력하세요")
    private String productName;

    @NotEmpty(message = "카테고리를 선택하세요")
    private String category;

    @NotNull(message = "안전재고 수량을 입력하세요")
    private Integer safetyStock;

    private Integer initialStock; //초기재고
    private String initialSupplier; //초기재고 공급업체
    private String initialInboundRemarks; //초기입고 비고
    private String unit;
    private String remarks;
}
