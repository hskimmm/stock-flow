package com.spring.stockflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id; // 기본키
    private String userId; // 사용자 ID
    private String password; //비밀번호
    private String userName; //사용자 이름
    private String Role; //권한
    private LocalDateTime regDate; //등록일
    private LocalDateTime modDate; //수정일
    private String delYn; //삭제여부
}
