package com.spring.stockflow.service.admin;

import com.spring.stockflow.domain.User;
import com.spring.stockflow.mapper.admin.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class AdminServiceImpl implements AdminService{
    private final AdminMapper adminMapper;

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
}
