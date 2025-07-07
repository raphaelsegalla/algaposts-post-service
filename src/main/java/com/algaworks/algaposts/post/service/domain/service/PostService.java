package com.algaworks.algaposts.post.service.domain.service;

import com.algaworks.algaposts.post.service.api.model.PostInput;
import com.algaworks.algaposts.post.service.domain.model.Post;
import com.algaworks.algaposts.post.service.domain.model.PostinputToProcessor;
import com.algaworks.algaposts.post.service.domain.repository.PostRepository;
import com.algaworks.algaposts.post.service.infrastructure.rabbitmq.RabbitMQConfig;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

import static com.algaworks.algaposts.post.service.infrastructure.rabbitmq.RabbitMQConfig.FANOUT_EXCHANGE_NAME;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final RabbitTemplate rabbitTemplate;

    public void sendPostToProcessor(PostInput input) {

        Post post = Post.builder()
                .id(UUID.randomUUID())
                .author(input.getAuthor())
                .title(input.getTitle())
                .body(input.getBody())
                .registeredAt(OffsetDateTime.now())
                .build();

        Post postSaved = postRepository.save(post);

        PostinputToProcessor postinput = PostinputToProcessor.builder()
                .postId(postSaved.getId().toString())
                .postBody(postSaved.getBody())
                .build();

        MessagePostProcessor messagePostProcessor = message -> {
            message.getMessageProperties().setHeader("postId", postSaved.getId().toString());
            return message;
        };

        String exchange = FANOUT_EXCHANGE_NAME;
        String routingKey = "";
        Object payload = postinput;

        rabbitTemplate.convertAndSend(exchange, routingKey, payload, messagePostProcessor);
    }

}
