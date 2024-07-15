package com.example.minibbs.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
public class CommentResponseDTO {
    private int id;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public CommentResponseDTO(int id, String content, String author,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
