package com.example.minibbs.service;
import com.example.minibbs.entity.Post;
import com.example.minibbs.dto.PostRequestDTO;
import com.example.minibbs.dto.PostResponseDTO;
import com.example.minibbs.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostResponseDTO> getPosts() {
        List<Post> posts = postRepository.findAllByOrderByIdDesc();
        List<PostResponseDTO> responses = new ArrayList<PostResponseDTO>();
        for (Post post : posts) {
            PostResponseDTO dto = PostResponseDTO.builder()
                                    .id(post.getId())
                                    .title(post.getTitle())
                                    .content(post.getContent())
                                    .author(post.getAuthor())
                                    .createdAt(post.getCreatedAt())
                                    .updatedAt(post.getUpdatedAt())
                                    .build();
            responses.add(dto);
        }
        return responses;
    }
    
    public boolean createPost(PostRequestDTO request) {
        try{
            Post newPost = Post.builder()
                            .title(request.getTitle())
                            .content(request.getContent())
                            .author(request.getAuthor())
                            .password(request.getPassword())
                            .build();
            postRepository.save(newPost);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PostResponseDTO getPost(int id) {
        Post post = postRepository.findById(id);
        if (post == null) {
            // post가 존재하지 않으면
            throw new IllegalArgumentException("No post found with id: " + id);
        } else {
            PostResponseDTO dto = PostResponseDTO.builder()
                                    .id(post.getId())
                                    .title(post.getTitle())
                                    .content(post.getContent())
                                    .author(post.getAuthor())
                                    .createdAt(post.getCreatedAt())
                                    .updatedAt(post.getUpdatedAt())
                                    .build();
            return dto;
        }
    }
        
    public boolean updatePost(int id, PostRequestDTO request) {
        Post post = postRepository.findById(id);
        if (post == null ||  !post.getPassword().equals(request.getPassword())) {
            // post가 존재하지 않거나, post와 비밀번호가 다르다면
            return false;
        } else {
            post.update(request.getTitle(), request.getContent());
            postRepository.save(post);
            return true;
        }
    }

    public boolean deletePost(int id, PostRequestDTO request) {
        Post post = postRepository.findById(id);
        if (post == null ||  !post.getPassword().equals(request.getPassword())) {
            // post가 존재하지 않거나, post와 비밀번호가 다르다면
            return false;
        } else {
            postRepository.deleteById(id);
            return true;
        }
    }
}
