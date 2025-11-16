package com.spring.stockflow.service.notice;

import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.mapper.notice.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Log4j2
public class NoticeServiceImpl implements NoticeService {
    private final NoticeMapper noticeMapper;

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
}
