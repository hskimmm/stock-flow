package com.spring.stockflow.dto;

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
public class EditUserDTO {
    @NotNull(message = "사용자가 존재하지 않습니다")
    private Long id;

    private String password;

    @NotEmpty(message = "이름을 입력하세요")
    private String userName;

    @NotEmpty(message = "권한을 선택하세요")
    private String role;
}
