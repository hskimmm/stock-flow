package com.spring.stockflow.mapper.notice;

import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.util.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> getNotices(Pagination pagination);

    Notice getNotice(Long id);

    void increaseViewCount(Long id);

    void addNotice(Notice notice);

    void editNotice(Notice notice);

    void deleteNotice(Long id);

    int getTotalNotice(Pagination pagination);
}
