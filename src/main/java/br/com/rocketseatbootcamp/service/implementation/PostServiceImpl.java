package br.com.rocketseatbootcamp.service.implementation;

import br.com.rocketseatbootcamp.exception.NotFoundException;
import br.com.rocketseatbootcamp.model.Post;
import br.com.rocketseatbootcamp.repository.IPostRepository;
import br.com.rocketseatbootcamp.service.interfaces.IPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private final IPostRepository postRepository;
    private final FileStorageService fileStorageService;

    public PostServiceImpl(IPostRepository postRepository, FileStorageService fileStorageService) {
        this.postRepository = postRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Post store(Post post, MultipartFile file) {
        LOGGER.info("Iniciando processo de salvar o post");
        LOGGER.debug("Post: {}", post);

        String fileName = fileStorageService.storeFile(file);
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        post.setImage(resource.getFilename());

        return this.postRepository.save(post);
    }

    @Override
    public List<Post> findAll(Sort sort) {
        return this.postRepository.findAll(sort);
    }

    @Override
    public Post findById(Long idPost) {
        return this.postRepository.findById(idPost).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar nenhum post com esse id -> " + idPost));
    }

    @Override
    public Post update(Post post) {
        return this.postRepository.save(post);
    }

}