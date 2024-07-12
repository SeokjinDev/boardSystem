package com.example.minibbs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class CommentId {
    @Column(name = "id")
    private int id;

    @Column(name = "post_id")
    private int postId;

    public CommentId(int id, int postId) {
        this.id = id;
        this.postId = postId;
    }
}
