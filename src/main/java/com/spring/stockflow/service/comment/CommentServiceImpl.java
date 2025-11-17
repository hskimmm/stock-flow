package com.spring.stockflow.service.comment;

import com.spring.stockflow.domain.Comment;
import com.spring.stockflow.dto.comment.CreateCommentDTO;
import com.spring.stockflow.dto.comment.EditCommentDTO;
import com.spring.stockflow.exception.CommentNotFoundException;
import com.spring.stockflow.exception.NoticeNotFoundException;
import com.spring.stockflow.mapper.comment.CommentMapper;
import com.spring.stockflow.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Transactional
    @Override
    public ApiResponse<?> addComment(CreateCommentDTO createCommentDTO) {
        try {
            Comment comment = Comment.builder()
                    .noticeId(createCommentDTO.getNoticeId())
                    .regUserId(createCommentDTO.getRegUserId())
                    .content(createCommentDTO.getContent())
                    .build();

            commentMapper.addComment(comment);
            return new ApiResponse<>(true, "댓글을 등록하였습니다");
        } catch (DataAccessException e) {
            log.error("댓글 등록(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 등록 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("댓글 등록(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 등록 중 오류가 발생하였습니다");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ApiResponse<?> getComments(Long id) {
        if (id == null) {
            throw new NoticeNotFoundException("공지사항이 존재하지 않습니다");
        }

        try {
            List<Comment> commentList = commentMapper.getComments(id);
            return new ApiResponse<>(true, "댓글목록조회", commentList);
        } catch (DataAccessException e) {
            log.error("댓글 조회(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 조회 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("댓글 조회(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 조회 중 오류가 발생하였습니다");
        }
    }

    @Transactional
    @Override
    public ApiResponse<?> editComment(EditCommentDTO editCommentDTO) {
        if (editCommentDTO.getId() == null) {
            throw new CommentNotFoundException("댓글이 존재하지 않습니다");
        }

        try {
            Comment comment = Comment.builder()
                    .id(editCommentDTO.getId())
                    .content(editCommentDTO.getContent())
                    .build();

            commentMapper.editComment(comment);
            return new ApiResponse<>(true, "댓글을 수정하였습니다");
        } catch (DataAccessException e) {
            log.error("댓글 수정(데이터베이스 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 수정 중 오류가 발생하였습니다");
        } catch (Exception e) {
            log.error("댓글 수정(기타 오류) = {}", e.getMessage());
            throw new RuntimeException("댓글 수정 중 오류가 발생하였습니다");
        }
    }
}
