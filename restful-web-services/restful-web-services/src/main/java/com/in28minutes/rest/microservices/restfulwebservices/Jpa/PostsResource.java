package com.in28minutes.rest.microservices.restfulwebservices.Jpa;

import com.in28minutes.rest.microservices.restfulwebservices.user.Posts;
import com.in28minutes.rest.microservices.restfulwebservices.user.User;
import com.in28minutes.rest.microservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
public class PostsResource {

    private JpaUserRepository jpaUserRepository;
    private PostsRepository postsRepository;

    public PostsResource(JpaUserRepository jpaUserRepository, PostsRepository postsRepository) {
        this.jpaUserRepository = jpaUserRepository;
        this.postsRepository = postsRepository;
    }


    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @RequestBody Posts posts){
        Optional<User> user=jpaUserRepository.findById(id);
        if(user.isEmpty())
        {
            throw new UserNotFoundException("id=="+id);

        }

        posts.setUser(user.get());
        Posts savedPost=postsRepository.save(posts);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
