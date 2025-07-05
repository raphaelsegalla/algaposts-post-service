package com.algaworks.algaposts.post.service.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostSummaryOutput {

    private String id;
    private String title;
    private String summary;
    private String author;

}
