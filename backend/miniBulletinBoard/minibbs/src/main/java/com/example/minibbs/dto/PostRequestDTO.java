package com.example.minibbs.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PostRequestDTO {
    private String title;
    private String content;
    private String author;
    private String password;

    @Builder
    public PostRequestDTO(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}
