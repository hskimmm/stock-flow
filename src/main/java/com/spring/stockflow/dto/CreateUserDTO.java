package com.spring.stockflow.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    @NotEmpty(message = "아이디를 입력하세요")
    private String userId;

    @NotEmpty(message = "비밀번호를 입력하세요")
    private String password;

    @NotEmpty(message = "이름을 입력하세요")
    private String userName;

    @NotEmpty(message = "권한을 선택하세요")
    private String role;
}
