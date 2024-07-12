package com.example.minibbs.controller;
import com.example.minibbs.dto.CommentRequestDTO;
import com.example.minibbs.dto.CommentResponseDTO;
import com.example.minibbs.service.CommentService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{postId}/comments")
    @ResponseBody
    public List<CommentResponseDTO> getComments(@PathVariable int postId) {
        return commentService.getComments(postId);
    }

    @PostMapping("/{postId}/comment")
    @ResponseBody
    public String createComment(@PathVariable int postId, @RequestBody CommentRequestDTO request) {
        request.update(postId);
        if (commentService.createComment(request)) {
            return "생성 성공";
        } else {
            return "생성 실패";
        }
    }

    @PutMapping("/{postId}/comment/{id}")
    @ResponseBody
    public String updateComment(@PathVariable int postId, @PathVariable int id, @RequestBody CommentRequestDTO request) {
        if (commentService.updateComment(id, request)) {
            return "수정 성공";
        } else {
            return "수정 실패";
        }
    }

    @DeleteMapping("/{postId}/comment/{id}")
    @ResponseBody
    public String deleteComment(@PathVariable int postId, @PathVariable int id, @RequestBody CommentRequestDTO request) {
        if (commentService.deleteComment(id, request)) {
            return "삭제 성공";
        } else {
            return "삭제 실패";
        }
    }
}
