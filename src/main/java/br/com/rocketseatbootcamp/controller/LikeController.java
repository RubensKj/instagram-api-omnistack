package br.com.rocketseatbootcamp.controller;

import br.com.rocketseatbootcamp.dto.PostDTO;
import br.com.rocketseatbootcamp.service.implementation.LikeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/posts/{id}/like")
    public PostDTO store(@PathVariable("id") Long id) {
        return PostDTO.of(this.likeService.store(id));
    }
}