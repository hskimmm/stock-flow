package com.spring.stockflow.service.notice;

import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.mapper.notice.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
