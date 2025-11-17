package com.spring.stockflow.service.comment;

import com.spring.stockflow.dto.comment.CreateCommentDTO;
import com.spring.stockflow.dto.comment.EditCommentDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.util.Pagination;
import jakarta.validation.Valid;

public interface CommentService {
    ApiResponse<?> addComment(@Valid CreateCommentDTO createCommentDTO);

    ApiResponse<?> getComments(Long id, Pagination pagination);

    ApiResponse<?> editComment(@Valid EditCommentDTO editCommentDTO);

    ApiResponse<?> deleteComment(Long id);

    int getTotalComment(Long id);
}
