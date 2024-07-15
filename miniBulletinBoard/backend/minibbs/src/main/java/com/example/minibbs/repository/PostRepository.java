package com.example.minibbs.repository;
import com.example.minibbs.entity.Post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findById(int id);
    List<Post> findAllByOrderByIdDesc();
    void deleteById(int id);
}