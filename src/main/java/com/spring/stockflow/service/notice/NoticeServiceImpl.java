package com.spring.stockflow.service.notice;

import com.spring.stockflow.domain.File;
import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.dto.notice.CreateNoticeDTO;
import com.spring.stockflow.dto.notice.EditNoticeDTO;
import com.spring.stockflow.mapper.file.FileMapper;
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
    private final FileMapper fileMapper;

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

    @Transactional(readOnly = true)
    @Override
    public Notice getNoticeDetail(Long id) {
        return noticeMapper.getNotice(id);
    }

    @Transactional
    @Override
    public ApiResponse<?> editNotice(EditNoticeDTO editNoticeDTO, List<MultipartFile> files, String[] deletedFileIds) {
        try {
            Notice notice = Notice.builder()
                    .id(editNoticeDTO.getId())
                    .noticeType(editNoticeDTO.getNoticeType())
                    .title(editNoticeDTO.getTitle())
                    .content(editNoticeDTO.getContent())
                    .isTop(editNoticeDTO.getIsTop())
                    .build();

            noticeMapper.editNotice(notice);

            //기존 파일 DB 삭제
            if (deletedFileIds != null) {
                for (String fileIdStr : deletedFileIds) {
                    Long fileId = Long.parseLong(fileIdStr);
                    fileMapper.deleteFile(fileId);
                }
            }

            //새 파일 추가
            if (files != null && !files.isEmpty()) {
                fileUploadHandler.saveFiles(files, "NOTICE", editNoticeDTO.getId());
            }

            return new ApiResponse<>(true, "공지사항을 수정하였습니다");
        } catch (IOException e) {
            log.error("공지사항 수정(파일 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 수정 중 오류가 발생하였습니다");
        } catch (DataAccessException e) {
            log.error("공지사항 수정(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 수정 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("공지사항 수정(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 수정 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> deleteNotice(Long id) {
        try {
            if (id == null) {
                throw new RuntimeException("공지사항이 존재하지 않습니다");
            }

            //파일 조회
            List<File> fileList = fileMapper.getFileList(id);
            if (fileList != null && !fileList.isEmpty()) {
                for (File file : fileList) {
                    fileUploadHandler.deleteFile(file);
                }
            }

            //공지사항 삭제
            noticeMapper.deleteNotice(id);

            return new ApiResponse<>(true, "공지사항을 삭제하였습니다");
        } catch (DataAccessException e) {
            log.error("공지사항 삭제(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 삭제 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("공지사항 삭제(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("공지사항 삭제 중 오류가 발생하였습니다");
        }
    }
}
