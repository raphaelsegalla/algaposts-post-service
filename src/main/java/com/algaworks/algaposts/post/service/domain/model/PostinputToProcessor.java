package com.algaworks.algaposts.post.service.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostinputToProcessor {

    private String postId;
    private String postBody;

}
