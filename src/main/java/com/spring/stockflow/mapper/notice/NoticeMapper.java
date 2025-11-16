package com.spring.stockflow.mapper.notice;

import com.spring.stockflow.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> getNotices();

    Notice getNotice(Long id);

    void increaseViewCount(Long id);
}
