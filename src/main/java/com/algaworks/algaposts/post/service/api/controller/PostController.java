package com.algaworks.algaposts.post.service.api.controller;

import com.algaworks.algaposts.post.service.api.model.PostInput;
import com.algaworks.algaposts.post.service.domain.repository.PostRepository;
import com.algaworks.algaposts.post.service.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostInput input) {
        log.info("Recebendo requisição para criar post com as informacoes: {}", input.toString());
        postService.sendPostToProcessor(input);
    }
}
