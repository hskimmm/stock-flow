package com.spring.stockflow.mapper.comment;

import com.spring.stockflow.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    void addComment(Comment comment);
}
