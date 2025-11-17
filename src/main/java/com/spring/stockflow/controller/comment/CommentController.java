package com.spring.stockflow.controller.comment;

import com.spring.stockflow.dto.comment.CreateCommentDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.comment.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<?>> getComments(@PathVariable(value = "id") Long id) {
        ApiResponse<?> response = commentService.getComments(id);
        return ResponseEntity.ok(response);
    }
}
