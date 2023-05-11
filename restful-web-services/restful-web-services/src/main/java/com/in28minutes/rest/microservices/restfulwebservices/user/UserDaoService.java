package com.in28minutes.rest.microservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users=new ArrayList<User>();
    private static Integer count=0;
    static {
        users.add(new User(++count,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++count,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++count,"Jim", LocalDate.now().minusYears(20)));

    }
    public List<User> findAll(){
        return users;
    }

    public User findByID(Integer id){
        return users.stream().filter(val->val.getId().equals(id)).findFirst().orElse(null);
    }

    public User saveUser(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }

    public void deleteByID(Integer id) {
        users.removeIf(user->user.getId().equals(id));

    }
}
