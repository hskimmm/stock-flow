package com.spring.stockflow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inbound {
    private Long id; //기본키
    private String inboundNo; //입고번호
    private Long productId; //상품 ID
    private String productName; //상품명
    private LocalDate inboundDate; //입고일자
    private Integer quantity; //입고수량
    private String supplier; //공급업체
    private String remarks; //비고
    private Long regUserId; //등록자 ID
    private LocalDateTime regDate; //등록일
}
