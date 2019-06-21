package br.com.rocketseatbootcamp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rocketseatbootcamp.models.Post;
import br.com.rocketseatbootcamp.repository.IPostRepository;

@RestController
public class LikeController {

    @Autowired
    private IPostRepository postRepository;

    @PostMapping("/posts/{id}/like")
    public ResponseEntity<Post> store(Post post) {
        Post postBanco = postRepository.findById(post.getId()).get();

        postBanco.setLike(postBanco.getLike() + 1);

        postRepository.save(postBanco);

        return ResponseEntity.ok().body(postBanco);
    }
}