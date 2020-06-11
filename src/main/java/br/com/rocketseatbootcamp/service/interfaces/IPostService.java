package br.com.rocketseatbootcamp.service.interfaces;

import br.com.rocketseatbootcamp.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPostService {

    Post store(Post post, MultipartFile file);

    List<Post> findAll(Sort createdAt);

    Post findById(Long idPost);

    Post update(Post post);
}