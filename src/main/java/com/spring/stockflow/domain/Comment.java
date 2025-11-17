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
public class Comment {
    private Long id; //기본키
    private Long noticeId; //공지사항 ID
    private Long parentId; //부모 댓글 ID
    private String content; //댓글 내용
    private Long regUserId; //작성자 ID
    private LocalDateTime regDate; //등록일시
    private LocalDateTime modDate; //수정일시
    private String delYn; //삭제여부
    private String userName; //등록자명
}
