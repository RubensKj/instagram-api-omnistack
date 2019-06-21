package br.com.rocketseatbootcamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rocketseatbootcamp.models.Post;
import br.com.rocketseatbootcamp.repository.IPostRepository;

@Service("IPostService")
public class PostServiceImpl implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public void store(Post post) {
        postRepository.save(post);
    }

}