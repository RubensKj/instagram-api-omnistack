package br.com.rocketseatbootcamp.dto;

import br.com.rocketseatbootcamp.model.Post;

import java.time.LocalDateTime;

public class PostDTO {

    private Long id;
    private String author;
    private String place;
    private String description;
    private String hashtags;
    private String image;
    private int likes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostDTO() {
    }

    public PostDTO(Long id, String author, String place, String description, String hashtags, String image, int likes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.author = author;
        this.place = place;
        this.description = description;
        this.hashtags = hashtags;
        this.image = image;
        this.likes = likes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static PostDTO of(Post post) {
        return new PostDTO(
                post.getId(),
                post.getAuthor(),
                post.getPlace(),
                post.getDescription(),
                post.getHashtags(),
                post.getImage(),
                post.getLike(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }

    public String getHashtags() {
        return hashtags;
    }

    public String getImage() {
        return image;
    }

    public int getLikes() {
        return likes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
