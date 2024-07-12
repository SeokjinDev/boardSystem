package com.example.minibbs.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CommentRequestDTO {
    private int postId;
    private String content;
    private String author;
    private String password;

    public CommentRequestDTO update(int postId) {
        this.postId = postId;
        return this;
    }

    @Builder
    public CommentRequestDTO(int postId, String content, String author, String password) {
        this.postId = postId;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}