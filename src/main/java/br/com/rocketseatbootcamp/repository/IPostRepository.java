package br.com.rocketseatbootcamp.repository;

import br.com.rocketseatbootcamp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
}