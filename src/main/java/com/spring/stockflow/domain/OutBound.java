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
public class OutBound {
    private Long id; //기본키
    private String outBoundNo; //출고번호
    private Long productId; //상품 ID
    private String productName; //상품명
    private LocalDate outboundDate; //출고일자
    private Integer quantity; //출고수량
    private String reason; //출고사유
    private String remarks; //비고
    private Long regUserId; //등록자 ID
    private String regUserName; //등록자명
    private LocalDateTime regDate; //등록일
}
