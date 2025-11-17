package com.spring.stockflow.mapper.comment;

import com.spring.stockflow.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    void addComment(Comment comment);

    List<Comment> getComments(Long id);

    void editComment(Comment comment);

    void deleteComment(Long id);
}
