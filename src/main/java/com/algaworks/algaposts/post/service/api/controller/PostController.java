package com.algaworks.algaposts.post.service.api.controller;

import com.algaworks.algaposts.post.service.api.model.PostInput;
import com.algaworks.algaposts.post.service.api.model.PostSummaryOutput;
import com.algaworks.algaposts.post.service.domain.repository.PostRepository;
import com.algaworks.algaposts.post.service.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostRepository postRepository;
//    private final PostService postService;

    @PostMapping
    public PostSummaryOutput createPost(@RequestBody PostInput input) {
        log.info("Recebendo requisição para criar post com as informacoes: {}", input.toString());

        return PostSummaryOutput.builder()
                .author(input.getAuthor())
                .title(input.getTitle())
                .summary(input.getBody())
                .build();
    }
}
