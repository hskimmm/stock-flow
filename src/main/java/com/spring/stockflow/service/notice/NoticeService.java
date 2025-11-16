package com.spring.stockflow.service.notice;

import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.dto.notice.CreateNoticeDTO;
import com.spring.stockflow.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoticeService {
    List<Notice> getNotices();

    Notice getNotice(Long id);

    ApiResponse<?> addNotice(@Valid CreateNoticeDTO createNoticeDTO, List<MultipartFile> files);
}
