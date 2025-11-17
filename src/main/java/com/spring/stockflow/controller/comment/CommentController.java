package com.spring.stockflow.controller.comment;

import com.spring.stockflow.dto.PageDTO;
import com.spring.stockflow.dto.comment.CreateCommentDTO;
import com.spring.stockflow.dto.comment.EditCommentDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.comment.CommentService;
import com.spring.stockflow.util.Pagination;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@Log4j2
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addComment(@Valid @RequestBody CreateCommentDTO createCommentDTO) {
        ApiResponse<?> response = commentService.addComment(createCommentDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getComments(@PathVariable(value = "id") Long id,
                                                      @ModelAttribute(value = "pagination")Pagination pagination) {
        ApiResponse<?> response = commentService.getComments(id, pagination);
        PageDTO pageDTO = new PageDTO(pagination, commentService.getTotalComment(id));

        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("commentList", response.getData());
        dataMap.put("page", pageDTO);

        ApiResponse<?> newResponse = new ApiResponse<>(true, response.getMessage(), dataMap);

        return ResponseEntity.ok(newResponse);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> editComment(@Valid @RequestBody EditCommentDTO editCommentDTO) {
        ApiResponse<?> response = commentService.editComment(editCommentDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> deleteComment(@RequestBody Long id) {
        ApiResponse<?> response = commentService.deleteComment(id);
        return ResponseEntity.ok(response);
    }

}
