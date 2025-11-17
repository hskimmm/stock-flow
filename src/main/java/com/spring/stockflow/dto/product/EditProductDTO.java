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
public class EditProductDTO {
    @NotNull(message = "존재하지 않는 상품입니다")
    private Long id;

    @NotEmpty(message = "상품 코드가 없습니다.")
    private String productCode;

    @NotEmpty(message = "상품명을 입력하세요")
    private String productName;

    @NotEmpty(message = "카테고리를 선택하세요")
    private String category;

    @NotEmpty(message = "단위를 선택하세요")
    private String unit;

    @NotNull(message = "안전재고 수량을 입력하세요")
    private Integer safetyStock;
    private String remarks;

}
