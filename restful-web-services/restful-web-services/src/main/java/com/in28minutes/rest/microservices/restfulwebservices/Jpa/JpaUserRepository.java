package com.in28minutes.rest.microservices.restfulwebservices.Jpa;

import com.in28minutes.rest.microservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JpaUserRepository extends JpaRepository<User, Integer> {

}
