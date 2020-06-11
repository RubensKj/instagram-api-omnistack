package br.com.rocketseatbootcamp.util;

import br.com.rocketseatbootcamp.dto.PostDTO;
import br.com.rocketseatbootcamp.model.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostUtil {

    private PostUtil() {
    }

    public static List<PostDTO> parsePostsToPostsDTO(List<Post> posts) {
        return posts.stream().map(PostDTO::of).collect(Collectors.toList());
    }
}
