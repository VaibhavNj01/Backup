package com.example.fakeapi.controller;

import com.example.fakeapi.model.Post;

import com.example.fakeapi.model.PostResponse;
import com.example.fakeapi.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class FakeApiController {
    private final PostService postService;

    public FakeApiController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "/posts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse> createPost(@RequestBody Post post) {
        PostResponse postResponse = postService.createPost(post);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);

    }

    @GetMapping(path = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping(path = "/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/posts/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostResponse> updateBook(@PathVariable Long id, @RequestBody PostResponse postResponse) {
        PostResponse updatePostResponse = postService.updatePost(id, postResponse);
        log.info("employee update successfully.......");
        return new ResponseEntity<>(updatePostResponse, HttpStatus.OK);

    }

}
