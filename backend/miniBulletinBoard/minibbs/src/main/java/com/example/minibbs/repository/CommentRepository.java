package com.example.minibbs.repository;
import com.example.minibbs.entity.Comment;
import com.example.minibbs.entity.CommentId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, CommentId> {
    Comment findByCommentId_Id(int id);
    List<Comment> findByCommentId_PostIdOrderByCommentId_IdDesc(int postId);
    void deleteByCommentId_IdAndCommentId_PostId(int id, int postId);
}