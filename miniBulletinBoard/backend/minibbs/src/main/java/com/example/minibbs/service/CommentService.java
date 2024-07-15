package com.example.minibbs.service;
import com.example.minibbs.entity.Comment;
import com.example.minibbs.entity.CommentId;
import com.example.minibbs.dto.CommentRequestDTO;
import com.example.minibbs.dto.CommentResponseDTO;
import com.example.minibbs.repository.CommentRepository;
import com.example.minibbs.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public List<CommentResponseDTO> getComments(int postId) {
        List<Comment> comments = commentRepository.findByCommentId_PostIdOrderByCommentId_IdDesc(postId);
        List<CommentResponseDTO> responses = new ArrayList<CommentResponseDTO>();
        for (Comment comment : comments) {
            
            CommentResponseDTO response = CommentResponseDTO.builder()
                                            .id(comment.getCommentId().getId())
                                            .content(comment.getContent())
                                            .author(comment.getAuthor())
                                            .createdAt(comment.getCreatedAt())
                                            .updatedAt(comment.getUpdatedAt())
                                            .build();

            responses.add(response);
        }
        return responses;
    }

    public boolean createComment(CommentRequestDTO request) {
        try {
            if (!postRepository.existsById(request.getPostId())) {
                throw new IllegalArgumentException("존재하지 않는 post id: " + request.getPostId());
            }
            CommentId commentId = new CommentId(0, request.getPostId());
            Comment newwComment = Comment.builder()
                                    .commentId(commentId)
                                    .content(request.getContent())
                                    .author(request.getAuthor())
                                    .password(request.getPassword())
                                    .build();
            commentRepository.save(newwComment);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean updateComment(int id, CommentRequestDTO request) {
        Comment comment = commentRepository.findByCommentId_Id(id);
        if (comment == null || !comment.getPassword().equals(request.getPassword())) {
            return false;
        } else {
            comment.update(request.getContent());
            commentRepository.save(comment);
            return true;
        }
    }

    public boolean deleteComment(int id, CommentRequestDTO request) {
        Comment comment = commentRepository.findByCommentId_Id(id);
        if (comment == null || !comment.getPassword().equals(request.getPassword())) {
            return false;
        } else {
            commentRepository.deleteByCommentId_IdAndCommentId_PostId(id, request.getPostId());
            return true;
        }
    }
}
