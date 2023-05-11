package com.in28minutes.rest.microservices.restfulwebservices.Jpa;

import com.in28minutes.rest.microservices.restfulwebservices.user.Posts;
import com.in28minutes.rest.microservices.restfulwebservices.user.User;
import com.in28minutes.rest.microservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResources {

    private JpaUserRepository jpaUserRepository;

    public UserJpaResources(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }



    @GetMapping("/jpa/users")
    public List<User> retreiveAllUsers(){

        return jpaUserRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retreiveUserByID(@PathVariable Integer id){
        Optional<User> user= jpaUserRepository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id=="+id);

        EntityModel<User> entityModel=EntityModel.of(user.get());
        WebMvcLinkBuilder link= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retreiveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User userCreated=jpaUserRepository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUserByID(@PathVariable Integer id){
        jpaUserRepository.deleteById(id);
    }


    @GetMapping("/jpa/users/{id}/posts")
    public List<Posts> retrieveAllPosts(@PathVariable Integer id){
        Optional<User> user=jpaUserRepository.findById(id);
        if(user.isEmpty())
        {
            throw new UserNotFoundException("id=="+id);

        }
        return user.get().getPosts();
    }




}
