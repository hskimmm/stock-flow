package com.spring.stockflow.mapper.comment;

import com.spring.stockflow.domain.Comment;
import com.spring.stockflow.util.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    void addComment(Comment comment);

    List<Comment> getComments(@Param(value = "id") Long id, @Param(value = "pagination") Pagination pagination);

    void editComment(Comment comment);

    void deleteComment(Long id);

    int getTotalComment(Long id);
}
