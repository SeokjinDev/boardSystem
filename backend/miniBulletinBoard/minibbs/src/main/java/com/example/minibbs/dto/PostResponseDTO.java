package com.example.minibbs.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
public class PostResponseDTO {
    private int id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public PostResponseDTO(int id, String title, String content, String author,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
