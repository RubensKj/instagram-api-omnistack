package br.com.rocketseatbootcamp.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.rocketseatbootcamp.models.Post;
import br.com.rocketseatbootcamp.repository.IPostRepository;
import br.com.rocketseatbootcamp.services.FileStorageService;
import br.com.rocketseatbootcamp.services.IPostService;

@RestController
public class PostController {

    @Autowired
    private IPostService postServiceImpl;

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        List<Post> posts = postRepository.findAll(Sort.by("createdAt").descending());
        return ResponseEntity.ok().body(posts);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> store(@RequestParam("file") MultipartFile file, HttpServletRequest req, Post post)
            throws IOException {
        String fileName = fileStorageService.storeFile(file);
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // String contextUrl = resource.getURI().toString().replace("file:///",
        // "").replace("Área%20de%20Trabalho",
        // "Desktop");

        post.setImage(resource.getFilename());
        postServiceImpl.store(post);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/uploads/resized/{image:.+}")
    public ResponseEntity<Resource> image(@PathVariable String image) {
        Resource file = fileStorageService.loadFileAsResource(image);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; image=\"" + file.getFilename() + "\"").body(file);
    }
}