package br.com.rocketseatbootcamp.controller;

import br.com.rocketseatbootcamp.service.implementation.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    private final FileStorageService fileStorageService;

    public ImageController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @GetMapping("/uploads/resized/{image:.+}")
    public ResponseEntity<Resource> image(@PathVariable String image) {
        Resource file = fileStorageService.loadFileAsResource(image);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; image=\"" + file.getFilename() + "\"").body(file);
    }
}
