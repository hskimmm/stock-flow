package com.spring.stockflow.dto.comment;

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
public class CreateCommentDTO {

    @NotNull(message = "공지사항이 존재하지 않습니다")
    private Long noticeId;

    @NotNull(message = "로그인 후 이용가능합니다")
    private Long regUserId;

    @NotEmpty(message = "댓글 내용을 입력하세요")
    private String content;
}
