package com.spring.stockflow.service.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.dto.CreateUserDTO;
import com.spring.stockflow.dto.EditUserDTO;
import com.spring.stockflow.mapper.admin.AdminMapper;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminServiceImpl implements AdminService{
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<User> getUsers() {
        try {
            return adminMapper.getUsers();
        } catch (DataAccessException e) {
            log.error("사용자 목록 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 목록 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("사용자 목록 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 목록 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<?> usersExists(String userId) {
        try {
            boolean exists = adminMapper.usersExists(userId);
            return new ApiResponse<>(true, "아이디 중복 검사 조회", exists);
        } catch (DataAccessException e) {
            log.error("아이디 중복 검사(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("아이디 중복 검사 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("아이디 중복 검사(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("아이디 중복 검사 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> createUser(CreateUserDTO createUserDTO) {
        try {
            User user = User.builder()
                    .userId(createUserDTO.getUserId())
                    .password(passwordEncoder.encode(createUserDTO.getPassword()))
                    .userName(createUserDTO.getUserName())
                    .role(createUserDTO.getRole())
                    .build();
            adminMapper.createUser(user);

            return new ApiResponse<>(true, "사용자를 등록하였습니다");
        } catch (DataAccessException e) {
            log.error("사용자 등록(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 등록 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("사용자 등록(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 등록 중 오류가 발생하였습니다");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(Long id) {
        try {
            return adminMapper.getUser(id);
        } catch (DataAccessException e) {
            log.error("사용자 상세 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 상세 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("사용자 상세 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 상세 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> editUser(EditUserDTO editUserDTO) {
        try {
            User user = User.builder()
                    .id(editUserDTO.getId())
                    .password(passwordEncoder.encode(editUserDTO.getPassword()))
                    .userName(editUserDTO.getUserName())
                    .role(editUserDTO.getRole())
                    .build();
            adminMapper.editUser(user);

            return new ApiResponse<>(true, "사용자 정보를 수정하였습니다");
        } catch (DataAccessException e) {
            log.error("사용자 정보 수정(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 정보 수정 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("사용자 정보 수정(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("사용자 정보 수정 중 오류가 발생하였습니다");
        }
    }
}
