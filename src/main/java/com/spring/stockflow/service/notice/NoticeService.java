package com.spring.stockflow.service.notice;

import com.spring.stockflow.domain.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> getNotices();

    Notice getNotice(Long id);
}
