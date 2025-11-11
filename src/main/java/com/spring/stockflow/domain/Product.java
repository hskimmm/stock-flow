package com.spring.stockflow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id; //기본키
    private String productCode; //상품코드
    private String productName; //상품명
    private String category; //카테고리
    private String unit; //단위
    private Integer safetyStock; //안전재고
    private Integer currentStock; //현재재고
    private String remarks; //비고
    private LocalDateTime regDate; //등록일
    private LocalDateTime modDate; //수정일
    private String delYn; //삭제여부
}
