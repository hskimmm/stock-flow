package com.spring.stockflow.service.notice;

import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.dto.notice.CreateNoticeDTO;
import com.spring.stockflow.mapper.notice.NoticeMapper;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.FileUploadHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Log4j2
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;
    private final FileUploadHandler fileUploadHandler;

    @Transactional(readOnly = true)
    @Override
    public List<Notice> getNotices() {
        return noticeMapper.getNotices();
    }

    @Transactional
    @Override
    public Notice getNotice(Long id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("공지사항 ID는 필수입니다.");
            }

            noticeMapper.increaseViewCount(id);
            Notice notice = noticeMapper.getNotice(id);

            if (notice == null) {
                throw new NoSuchElementException("공지사항을 찾을 수 없습니다.");
            }
            return notice;
        } catch (Exception e) {
            log.error("공지사항 조회 실패: {}", e.getMessage());
            return null;
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> addNotice(CreateNoticeDTO createNoticeDTO, List<MultipartFile> files) {
        try {
            Notice notice = Notice.builder()
                    .noticeType(createNoticeDTO.getNoticeType())
                    .title(createNoticeDTO.getTitle())
                    .content(createNoticeDTO.getContent())
                    .isTop(createNoticeDTO.getIsTop())
                    .regUserId(createNoticeDTO.getUserId())
                    .build();

            noticeMapper.addNotice(notice);

            //파일 첨부인 경우
            if (files != null && !files.isEmpty()) {
                fileUploadHandler.saveFiles(files, "NOTICE", notice.getId());
            }

            return new ApiResponse<>(true, "공지사항을 등록하였습니다");
        } catch (IOException e) {
            log.error("공지사항 등록(파일 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 등록 중 오류가 발생하였습니다");
        } catch (DataAccessException e) {
            log.error("공지사항 등록(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 등록 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("공지사항 등록(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 등록 중 오류가 발생하였습니다");
        }
    }
}
