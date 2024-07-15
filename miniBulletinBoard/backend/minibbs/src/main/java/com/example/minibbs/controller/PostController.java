package com.example.minibbs.controller;
import com.example.minibbs.dto.PostRequestDTO;
import com.example.minibbs.dto.PostResponseDTO;
import com.example.minibbs.service.PostService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    @ResponseBody
    public List<PostResponseDTO> getPosts() {
        return postService.getPosts();
    }
    
    @PostMapping("/post")
    @ResponseBody
    public String createPost(@RequestBody PostRequestDTO request) {
        if (postService.createPost(request)) {
            return "생성 성공";
        } else {
            return "생성 실패";
        }
    }

    @GetMapping("/post/{id}")
    @ResponseBody
    public PostResponseDTO getPost(@PathVariable int id) {
        return postService.getPost(id);
    }
    

    @PutMapping("/post/{id}")
    @ResponseBody
    public String updatePost(@PathVariable int id, @RequestBody PostRequestDTO request) {
        if (postService.updatePost(id, request)) {
            return "수정 성공";
        } else {
            return "수정 실패";
        }
    }
    

    @DeleteMapping("/post/{id}")
    @ResponseBody
    public String deletePost(@PathVariable int id, @RequestBody PostRequestDTO request) {
        if (postService.deletePost(id, request)) {
            return "삭제 성공";
        } else {
            return "삭제 실패";
        }
    }
    

}
