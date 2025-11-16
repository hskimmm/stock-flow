package com.spring.stockflow.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    private Long id; //기본키
    private String title; //제목
    private String content; //내용
    private String noticeType; //공지유형(NORMAL:일반, IMPORTANT:중요)
    private Integer viewCount; //조회수
    private String isTop; //상단고정여부
    private Long regUserId; //등록자 ID
    private String regUserName; //등록자명
    private LocalDateTime regDate; //등록일
    private LocalDateTime modDate; //수정일
    private String delYn; //삭제여부
    private List<File> fileList; //파일 리스트
}
