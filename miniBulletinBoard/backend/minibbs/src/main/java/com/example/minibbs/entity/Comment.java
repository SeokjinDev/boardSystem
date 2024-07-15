package com.example.minibbs.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "comments")
public class Comment {
    @EmbeddedId
    private CommentId commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "pw")
    private String password;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Comment update(String content) {
        this.content = content;
        return this;
    }

    @Builder(toBuilder = true)
    public Comment(CommentId commentId, String content, String author, String password) {
        this.commentId = commentId;
        this.content = content;
        this.author = author;
        this.password = password;
    }

}