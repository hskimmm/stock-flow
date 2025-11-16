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
public class File {
    private Long id; //기본키
    private String refType; //참조 테이블 구분(NOTICE, PRODUCT, INBOUND, OUTBOUND)
    private Long refId; //참조 테이블 ID
    private String fileType; //파일 유형(IMAGE, DOCUMENT, ATTACHMENT)
    private String originalName; //원본 파일명
    private String savedName; //저장 파일명
    private String filePath; //파일 경로
    private Long fileSize; //파일 크기
    private String fileExt; //파일 확장자
    private Integer downloadCount; //다운로드 횟수
    private Integer displayOrder; //표시 순서
    private LocalDateTime regDate; //등록일
}
