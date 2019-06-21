package br.com.rocketseatbootcamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rocketseatbootcamp.models.Post;

@Repository("PostRepository")
public interface IPostRepository extends JpaRepository<Post, Integer> {

}