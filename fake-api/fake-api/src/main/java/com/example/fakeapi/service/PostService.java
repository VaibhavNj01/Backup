package com.example.fakeapi.service;

import com.example.fakeapi.model.Post;
import com.example.fakeapi.model.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostService extends HttpEntity {
    private final RestTemplate restTemplate;

    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${property.url}")
    private String fakeUrl;

    public PostResponse createPost(Post post) {
        HttpEntity<Post> postHttpEntity = new HttpEntity<>(post);
        PostResponse postResponse = restTemplate.exchange(fakeUrl + "/posts", HttpMethod.POST, postHttpEntity, PostResponse.class).getBody();
        return postResponse;
    }

    public Post getPost(Long id) {
        Post post = restTemplate.getForObject(fakeUrl + "/posts/{userId}", Post.class, id);
        return post;
    }

    public void deletePost(Long id) {
        restTemplate.delete(fakeUrl + "/posts/{id}", Post.class, id);
    }

    public PostResponse updatePost(Long id, PostResponse postResponse) {
        HttpEntity http = new HttpEntity<>(postResponse);
        ResponseEntity<PostResponse> response = restTemplate.exchange(fakeUrl + "/posts/" + id, HttpMethod.PUT, http, PostResponse.class, id);
        return response.getBody();

    }
}
