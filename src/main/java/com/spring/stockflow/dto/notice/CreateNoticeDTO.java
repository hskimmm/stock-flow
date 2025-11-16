package com.spring.stockflow.dto.notice;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoticeDTO {
    @NotEmpty(message = "구분을 선택하세요")
    private String noticeType;

    @NotEmpty(message = "제목을 입력하세요")
    private String title;

    @NotEmpty(message = "내용을 입력하세요")
    private String content;

    private String isTop;
    private Long userId;
}
