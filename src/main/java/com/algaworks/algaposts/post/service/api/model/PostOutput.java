package com.algaworks.algaposts.post.service.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostOutput {

    private String id;
    private String title;
    private String body;
    private String author;
    private String wordCount;
    private String calculatedValue;

}
