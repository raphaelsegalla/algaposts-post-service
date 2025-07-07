package com.algaworks.algaposts.post.service.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private UUID id;
    private String title;
    private String body;
    private String author;
    private Long wordCount;
    private BigDecimal calculatedValue;
    private OffsetDateTime registeredAt;
    private OffsetDateTime updatedAt;

}
