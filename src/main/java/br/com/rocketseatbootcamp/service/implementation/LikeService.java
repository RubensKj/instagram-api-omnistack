package br.com.rocketseatbootcamp.service.implementation;

import br.com.rocketseatbootcamp.model.Post;
import br.com.rocketseatbootcamp.service.implementation.PostServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final PostServiceImpl postService;

    public LikeService(PostServiceImpl postService) {
        this.postService = postService;
    }

    public Post store(Long idPost) {
        Post post = this.postService.findById(idPost);

        post.setLike(incrementLike(post.getLike()));

        return this.postService.update(post);
    }

    private int incrementLike(int like) {
        return (like++);
    }
}
