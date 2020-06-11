package br.com.rocketseatbootcamp.controller;

import br.com.rocketseatbootcamp.dto.PostDTO;
import br.com.rocketseatbootcamp.model.Post;
import br.com.rocketseatbootcamp.service.interfaces.IPostService;
import br.com.rocketseatbootcamp.util.PostUtil;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    private final IPostService postServiceImpl;

    public PostController(IPostService postServiceImpl) {
        this.postServiceImpl = postServiceImpl;
    }

    @GetMapping("/posts")
    public List<PostDTO> getPosts() {
        return PostUtil.parsePostsToPostsDTO(postServiceImpl.findAll(Sort.by("createdAt").descending()));
    }

    @PostMapping("/posts")
    public PostDTO store(@RequestParam("file") MultipartFile file, @Valid @RequestBody Post post) {
        return PostDTO.of(this.postServiceImpl.store(post, file));
    }
}