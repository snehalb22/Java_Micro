package com.in28minutes.rest.microservices.restfulwebservices.Jpa;

import com.in28minutes.rest.microservices.restfulwebservices.user.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Integer> {
}
